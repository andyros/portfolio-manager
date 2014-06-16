package pm.server.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PM_INSTRUMENT")
public class Instrument extends AbstractEntity {

	@Id
	@SequenceGenerator(name = "SEQ_PM_INSTRUMENT", sequenceName = "SEQ_PM_INSTRUMENT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PM_INSTRUMENT")
	@Column(name = "INSTRUMENT_ID", nullable = false)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
