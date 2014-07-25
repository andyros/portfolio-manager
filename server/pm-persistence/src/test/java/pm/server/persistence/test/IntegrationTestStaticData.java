package pm.server.persistence.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import pm.server.persistence.dao.InstrumentRepository;
import pm.server.persistence.dao.PortfolioEntryRepository;
import pm.server.persistence.entity.Instrument;

/**
 * Simple class to encapsulate creation of various bits of static data required for tests.
 */
public class IntegrationTestStaticData {

    @Resource
    private InstrumentRepository instrumentRepository;

    @Resource
    private PortfolioEntryRepository portfolioEntryRepository;

    /**
     * Creates a selection of test instruments.
     */
    public Map<String, Instrument> createInstruments() {
        Map<String, Instrument> dataMap = new HashMap<>(3);
        dataMap.put("VOD", new Instrument("VOD"));
        dataMap.put("BP", new Instrument("BP"));
        dataMap.put("GSK", new Instrument("GSK"));

        for (Instrument i : dataMap.values()) {
            this.instrumentRepository.save(i);
        }
        return dataMap;
    }
}
