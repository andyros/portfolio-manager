package pm.server.test;

import java.text.ParseException;

import org.springframework.boot.test.SpringApplicationConfiguration;

import pm.server.PMCoreApplication;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.persistence.entity.PortfolioEntry.Direction;

@SpringApplicationConfiguration(classes = {PMCoreApplication.class,
        IntegrationTestConfiguration.class})
public abstract class AbstractIntegrationTest {

    protected PortfolioEntry newPortfolioEntry(Portfolio p, String ddMMyyyy, String quantity,
            String price, Direction direction, Instrument instr) throws ParseException {
        return TestUtil.newPortfolioEntry(p, ddMMyyyy, quantity, price, direction, instr);
    }
}
