package pm.server.core;

import java.util.List;

import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.persistence.entity.PortfolioFundamental;

public interface PortfolioCalculationService {

    /**
     * Recalculates the fundamentals for the portfolio.
     *
     * If the new portfolio entries contain an instrument for which there is no existing fundamental
     * then one will be created but not persisted.
     *
     * When a fundamental does exist then it will be retrieved from the database but returned in a
     * dirty state. It is not the responsibility of this method to persist the results.
     *
     * @param p the portfolio
     * @param newEntries the new portfolio entries
     * @return the created / updated fundamentals
     */
    List<PortfolioFundamental> recalculateFundamentals(Portfolio p, List<PortfolioEntry> newEntries);
}
