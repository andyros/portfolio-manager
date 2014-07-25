package pm.server.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pm.server.persistence.entity.PortfolioEntry;

public interface PortfolioEntryRepository extends JpaRepository<PortfolioEntry, Long> {

    @Query(value = "from PortfolioEntry pe where pe.portfolio.id = ?")
    List<PortfolioEntry> findByPortfolioId(Long portfolioId);
}
