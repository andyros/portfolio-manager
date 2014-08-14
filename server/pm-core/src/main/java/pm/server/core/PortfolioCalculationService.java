package pm.server.core;

import java.util.List;
import java.util.Map;

import pm.server.core.dto.PortfolioFundamental;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.PortfolioEntry;

public interface PortfolioCalculationService {

    /**
     * Calculates the fundamentals for the given portfolio entries.
     *
     * Entries are grouped by instrument id and fundamentals are calculated. PortfolioFundamental
     * objects are returned for each instrument id, containing the calculated results.
     *
     * @param entries the entries to calculate for
     * @return a map of the calculated fundamentals, keyed by instrument
     */
    Map<Instrument, PortfolioFundamental> recalculateFundamentals(List<PortfolioEntry> entries);
}
