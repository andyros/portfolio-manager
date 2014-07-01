package pm.server.persistence.dao;

import org.springframework.data.repository.Repository;

import pm.server.persistence.entity.Instrument;

public interface InstrumentRepository extends Repository<Instrument, Long> {
}
