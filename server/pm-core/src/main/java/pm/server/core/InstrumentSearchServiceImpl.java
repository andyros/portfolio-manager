package pm.server.core;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import pm.server.persistence.dao.InstrumentRepository;
import pm.server.persistence.entity.Instrument;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class InstrumentSearchServiceImpl implements InstrumentSearchService {

    @Resource
    private InstrumentRepository instrumentRepository;

    private List<Instrument> allInstruments = null;

    @Override
    public Collection<Instrument> findInstruments(String text) {
        initializeInstruments();
        return Collections2.filter(this.allInstruments, new PredicateImpl(text));
    }

    private void initializeInstruments() {
        if (this.allInstruments == null) {
            this.allInstruments = this.instrumentRepository.findAll();
        }
    }

    private static class PredicateImpl implements Predicate<Instrument> {

        private final String text;

        public PredicateImpl(String text) {
            super();
            this.text = text;
        }

        @Override
        public boolean apply(Instrument input) {
            String primaryIdentifier = input.getPrimaryIdentifier();
            String name = input.getName();
            return primaryIdentifier.contains(this.text) || name.contains(this.text);
        }

    }
}
