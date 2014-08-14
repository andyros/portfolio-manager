package pm.server.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pm.server.core.dto.PortfolioFundamental;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.persistence.entity.PortfolioEntry.Direction;

public class TestUtil {

    private static DateFormat portfolioEntryDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private TestUtil() {}

    public static PortfolioEntry newPortfolioEntry(Portfolio p, String ddMMyyyy, String quantity,
            String price, Direction direction, Instrument instr) {

        try {
            PortfolioEntry pe = new PortfolioEntry();
            pe.setDirection(direction);
            pe.setInsertDateTime(portfolioEntryDateFormat.parse(ddMMyyyy));
            pe.setInstrument(instr);
            pe.setPortfolio(p);
            pe.setPrice(new BigDecimal(price));
            pe.setQuantity(new BigDecimal(quantity));
            return pe;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<Instrument, PortfolioFundamental> fundamentalListToMap(
            List<PortfolioFundamental> list) {
        Map<Instrument, PortfolioFundamental> map = new HashMap<>(list.size());
        // for (PortfolioFundamental pf : list) {
        // Assert.isTrue(!map.containsKey(pf.getInstrument()), "duplicate PortfolioFundamental");
        // map.put(pf.getInstrument(), pf);
        // }
        return map;
    }
}
