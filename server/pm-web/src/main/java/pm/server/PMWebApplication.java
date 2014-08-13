package pm.server;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pm.server.web.model.conversion.ModelConvertor;
import pm.server.web.model.conversion.ModelConvertorImpl;

/**
 * Main entry point for the application.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class PMWebApplication {

    private static final Logger log = LoggerFactory.getLogger(PMWebApplication.class);

    public static void main(final String[] args) {
        log.info("Launching application with spring boot...");
        SpringApplication.run(PMWebApplication.class, args);
    }

    @Bean
    public Mapper dozerMapper() {
        List<String> mappingFileUrls = new ArrayList<String>();
        mappingFileUrls.add("dozer/Portfolio.xml");
        mappingFileUrls.add("dozer/PortfolioEntry.xml");

        DozerBeanMapper dbm = new DozerBeanMapper();
        dbm.setMappingFiles(mappingFileUrls);
        return dbm;
    }


    @Bean
    public ModelConvertor modelConvertor() {
        return new ModelConvertorImpl();
    }
}
