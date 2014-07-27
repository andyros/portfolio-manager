package pm.server.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import pm.server.persistence.dao.PortfolioFundamentalRepository;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.persistence.entity.PortfolioFundamental;

public class PortfolioCalculationServiceImpl implements PortfolioCalculationService {

    private PortfolioFundamentalRepository portfolioFundamentalRepository;

    @Override
    public List<PortfolioFundamental> recalculateFundamentals(Portfolio p,
            List<PortfolioEntry> newEntries) {
        Map<Instrument, List<PortfolioEntry>> entriesByInstrumentId = mapByInstrumentId(newEntries);
        List<PortfolioFundamental> fundamentals = new ArrayList<>(entriesByInstrumentId.size());

        for (Entry<Instrument, List<PortfolioEntry>> e : entriesByInstrumentId.entrySet()) {
            Instrument i = e.getKey();

            PortfolioFundamental fundamental =
                    this.portfolioFundamentalRepository.getByPortfolioIdAndInstrumentId(p.getId(),
                            i.getId());

            if (fundamental == null) {
                fundamental = new PortfolioFundamental();
                fundamental.setInstrument(i);
                fundamental.setPortfolio(p);
            }

            List<PortfolioEntry> newEntriesForInstrument = e.getValue();
            recalculate(fundamental, newEntriesForInstrument);
            fundamentals.add(fundamental);
        }

        return fundamentals;
    }

    private void recalculate(PortfolioFundamental fundamental, List<PortfolioEntry> newEntries) {


    }

    private Map<Instrument, List<PortfolioEntry>> mapByInstrumentId(List<PortfolioEntry> newEntries) {
        Map<Instrument, List<PortfolioEntry>> map = new HashMap<>();
        for (PortfolioEntry pe : newEntries) {
            Instrument instrument = pe.getInstrument();
            List<PortfolioEntry> list = map.get(instrument.getId());
            if (list == null) {
                list = new ArrayList<>();
                map.put(instrument, list);
            }
            list.add(pe);
        }
        return map;
    }
}
