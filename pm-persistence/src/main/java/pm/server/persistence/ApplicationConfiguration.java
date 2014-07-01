package pm.server.persistence;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pm.server.persistence.dao.InstrumentRepository;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationConfiguration {

    @Bean
    public DataSource dataSource() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/portman";
        String user = "postgres";
        String password = "password";

        try {
            PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
            pgSimpleDataSource.setUrl(jdbcUrl);
            pgSimpleDataSource.setUser(user);
            pgSimpleDataSource.setPassword(password);
            return pgSimpleDataSource;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("pm.server.persistence.entity");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public InstrumentRepository instrumentRepository() {
        return new InstrumentRepository(entityManager());
    }
}
