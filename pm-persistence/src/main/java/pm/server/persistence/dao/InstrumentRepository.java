package pm.server.persistence.dao;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;

import pm.server.persistence.entity.Instrument;

public class InstrumentRepository extends SimpleJpaRepository<Instrument, Long> implements
        CrudRepository<Instrument, Long> {

    public InstrumentRepository(EntityManager em) {
        super(Instrument.class, em);
    }
}
