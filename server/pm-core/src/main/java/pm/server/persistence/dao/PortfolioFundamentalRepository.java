package pm.server.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pm.server.persistence.entity.PortfolioFundamental;

public interface PortfolioFundamentalRepository extends JpaRepository<PortfolioFundamental, Long> {

    @Query("from PortfolioFundamental pe where pe.portfolio.id = ? and pe.instrument.id = ?")
    PortfolioFundamental getByPortfolioIdAndInstrumentId(Long portfolioId, Long instrumentId);

    @Query("from PortfolioFundamental pe where pe.portfolio.id = ?")
    List<PortfolioFundamental> findByPortfolioId(Long portfolioId);
}
