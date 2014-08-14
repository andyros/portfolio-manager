package pm.server.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import pm.server.core.dto.PortfolioFundamental;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.persistence.entity.PortfolioEntry.Direction;

public class PortfolioCalculationServiceImpl implements PortfolioCalculationService {

    @Resource
    private MarketPriceService marketPriceService;

    @Override
    public Map<Instrument, PortfolioFundamental> recalculateFundamentals(
            List<PortfolioEntry> entries) {
        Map<Instrument, List<PortfolioEntry>> entriesByInstrumentId = mapByInstrumentId(entries);
        Map<Instrument, PortfolioFundamental> fundamentals =
                new HashMap<>(entriesByInstrumentId.size());

        for (Entry<Instrument, List<PortfolioEntry>> e : entriesByInstrumentId.entrySet()) {
            Instrument i = e.getKey();

            PortfolioFundamental f = fundamentals.get(i.getId());
            if (f == null) {
                f = new PortfolioFundamental();
                f.setInstrument(i);
                f.setTotalCost(BigDecimal.ZERO);
                f.setTotalSharesHeld(BigDecimal.ZERO);
                fundamentals.put(i, f);
            }

            List<PortfolioEntry> entriesForInstrument = e.getValue();
            recalculate(f, entriesForInstrument);
        }

        for (Entry<Instrument, PortfolioFundamental> e : fundamentals.entrySet()) {
            Instrument i = e.getKey();
            PortfolioFundamental f = e.getValue();

            BigDecimal currentPrice = this.marketPriceService.getCurrentPrice(i.getId());
            BigDecimal marketCost = currentPrice.multiply(f.getTotalSharesHeld());

            f.setCurrentPrice(currentPrice);
            f.setMarketCost(marketCost.setScale(2, RoundingMode.HALF_UP));
        }

        return fundamentals;
    }

    private void recalculate(PortfolioFundamental fundamental, List<PortfolioEntry> entries) {
        BigDecimal costDelta = BigDecimal.ZERO;
        BigDecimal totalSharesDelta = BigDecimal.ZERO;
        for (PortfolioEntry pe : entries) {
            Direction direction = pe.getDirection();

            BigDecimal entryCost = pe.getQuantity().multiply(pe.getPrice());
            costDelta = addOrSubtractByDirection(direction, costDelta, entryCost);
            totalSharesDelta =
                    addOrSubtractByDirection(direction, totalSharesDelta, pe.getQuantity());
        }

        BigDecimal newCost = fundamental.getTotalCost().add(costDelta);
        BigDecimal newTotalShares = fundamental.getTotalSharesHeld().add(totalSharesDelta);

        fundamental.setTotalCost(newCost.setScale(2, RoundingMode.HALF_UP));
        fundamental.setTotalSharesHeld(newTotalShares.setScale(2, RoundingMode.HALF_UP));
    }

    private Map<Instrument, List<PortfolioEntry>> mapByInstrumentId(List<PortfolioEntry> newEntries) {
        Map<Instrument, List<PortfolioEntry>> map = new HashMap<>();
        for (PortfolioEntry pe : newEntries) {
            Instrument instrument = pe.getInstrument();
            List<PortfolioEntry> list = map.get(instrument);
            if (list == null) {
                list = new ArrayList<>();
                map.put(instrument, list);
            }
            list.add(pe);
        }
        return map;
    }

    private BigDecimal addOrSubtractByDirection(Direction direction, BigDecimal a, BigDecimal b) {
        switch (direction) {
            case BUY:
                return a.add(b);
            case SELL:
                return a.subtract(b);
            default:
                throw new IllegalStateException("Unhandled direction '" + direction + "'");
        }
    }
}
