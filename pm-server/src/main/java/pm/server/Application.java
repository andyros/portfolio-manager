package pm.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main entry point for the application.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
public class Application {

    public static void main(final String[] args) {
        System.out.println("Launching application with spring boot...");
        SpringApplication.run(Application.class, args);
    }
}
