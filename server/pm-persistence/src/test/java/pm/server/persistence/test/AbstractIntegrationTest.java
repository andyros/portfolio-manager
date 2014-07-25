package pm.server.persistence.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.test.SpringApplicationConfiguration;

import pm.server.persistence.ApplicationConfiguration;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.persistence.entity.PortfolioEntry.Direction;

@SpringApplicationConfiguration(classes = {ApplicationConfiguration.class,
        IntegrationTestConfiguration.class})
public abstract class AbstractIntegrationTest {

    private DateFormat portfolioEntryDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    protected PortfolioEntry newPortfolioEntry(Portfolio p, String ddMMyyyy, String quantity,
            String price, String value, Direction direction, Instrument instr)
            throws ParseException {

        PortfolioEntry pe = new PortfolioEntry();
        pe.setDirection(direction);
        pe.setInsertDateTime(this.portfolioEntryDateFormat.parse(ddMMyyyy));
        pe.setInstrument(instr);
        pe.setPortfolio(p);
        pe.setPrice(new BigDecimal(price));
        pe.setQuantity(new BigDecimal(quantity));
        return pe;
    }
}
