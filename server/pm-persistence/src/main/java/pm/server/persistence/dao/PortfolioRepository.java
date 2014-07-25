package pm.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pm.server.persistence.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    @Query(value = "from Portfolio p where p.name = ?")
    Portfolio getByName(String portfolioName);
}
