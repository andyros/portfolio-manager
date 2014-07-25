package pm.server.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pm.server.persistence.entity.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

    @Query(value = "from Instrument i where i.primaryIdentifier = ?")
    Instrument getByPrimaryIdentifier(String primaryIdentifier);
}
