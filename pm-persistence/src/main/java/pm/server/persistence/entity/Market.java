package pm.server.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PM_MARKET")
public class Market extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "SEQ_PM_MARKET", sequenceName = "SEQ_PM_MARKET")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PM_MARKET")
    @Column(name = "MARKET_ID", nullable = false)
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
