package pm.server.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationTestConfiguration {

    @Bean
    public IntegrationTestStaticData integrationTestStaticData() {
        return new IntegrationTestStaticData();
    }
}
