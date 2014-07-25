package pm.server.persistence.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.persistence.entity.PortfolioEntry.Direction;
import pm.server.persistence.test.AbstractIntegrationTest;
import pm.server.persistence.test.IntegrationTestStaticData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(inheritLocations = true)
@ActiveProfiles("int-test")
public class RepositoryIT extends AbstractIntegrationTest {

    @Resource
    private InstrumentRepository instrumentRepository;

    @Resource
    private PortfolioRepository portfolioRepository;

    @Resource
    private PortfolioEntryRepository portfolioEntryRepository;

    @Resource
    private IntegrationTestStaticData integrationTestStaticData;

    @Test
    @Transactional
    public void testLookupQueries() throws ParseException {
        // create some instruments
        Map<String, Instrument> instruments = this.integrationTestStaticData.createInstruments();
        Instrument vod = instruments.get("VOD");

        // create a portfolio
        Portfolio p = new Portfolio();
        p.setName("MyPortfolio");
        this.portfolioRepository.save(p);

        // create some entries
        List<PortfolioEntry> entries = new ArrayList<>(7);
        entries.add(newPortfolioEntry(p, "06/12/2012", "499", "5.4", "2694.6", Direction.BUY, vod));
        entries.add(newPortfolioEntry(p, "27/10/2010", "292", "6.3", "1839.6", Direction.BUY, vod));
        entries.add(newPortfolioEntry(p, "05/10/2014", "220", "8", "1760", Direction.BUY, vod));
        entries.add(newPortfolioEntry(p, "06/07/2010", "712", "5.6", "3987.2", Direction.BUY, vod));
        entries.add(newPortfolioEntry(p, "28/01/2014", "693", "4.7", "3257.1", Direction.BUY, vod));

        entries.add(newPortfolioEntry(p, "08/12/2012", "500", "5", "2500", Direction.SELL, vod));
        entries.add(newPortfolioEntry(p, "09/12/2012", "200", "4.8", "960", Direction.SELL, vod));

        this.portfolioEntryRepository.save(entries);

        // assert look-ups
        assertNotNull(this.instrumentRepository.getByPrimaryIdentifier("VOD"));
        assertNotNull(this.portfolioRepository.getByName("MyPortfolio"));
        assertEquals(7, this.portfolioEntryRepository.findByPortfolioId(p.getId()).size());
    }

    @Test
    @Transactional
    public void testAuditing() throws InterruptedException {
        // create some instruments
        Map<String, Instrument> instruments = this.integrationTestStaticData.createInstruments();

        // assert that the insert time has been correctly set
        Instrument vod = instruments.get("VOD");
        assertNotNull(vod.getInsertDateTime());
        assertNotNull(vod.getModifiedDateTime());
    }
}
