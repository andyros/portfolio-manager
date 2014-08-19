package pm.server.core;

import java.util.Collection;

import pm.server.persistence.entity.Instrument;

public interface InstrumentSearchService {

    /**
     * Returns matching instruments. An instrument is considered a match if it's primary identifier
     * or name contains the given {@code text}.
     *
     * @param text the text to search with
     * @return the matches
     */
    Collection<Instrument> findInstruments(String text);
}
