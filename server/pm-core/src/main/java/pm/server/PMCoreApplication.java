package pm.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pm.server.core.MarketPriceService;
import pm.server.core.MarketPriceServiceImpl;
import pm.server.core.PortfolioCalculationService;
import pm.server.core.PortfolioCalculationServiceImpl;

@Configuration
@EnableJpaRepositories
@EnableJpaAuditing
@EnableTransactionManagement
@EnableAutoConfiguration
public class PMCoreApplication {

    @Bean
    public PortfolioCalculationService portfolioCalculationService() {
        return new PortfolioCalculationServiceImpl();
    }

    @Bean
    public MarketPriceService marketPriceService() {
        return new MarketPriceServiceImpl();
    }
}
