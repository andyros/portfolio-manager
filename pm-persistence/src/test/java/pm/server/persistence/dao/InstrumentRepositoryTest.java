package pm.server.persistence.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pm.server.persistence.ApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class InstrumentRepositoryTest {

    @Resource
    private InstrumentRepository instrumentRepository;

    @Test
    public void testById() {
        System.out.println();
        this.instrumentRepository.getOne(Long.valueOf(1));
    }
}
