package pm.server.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MARKET_ID", nullable = false)
    private Market market;

    @Column(name = "PRIMARY_IDENTIFIER", nullable = false)
    private String primaryIdentifier;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result =
                prime * result
                        + ((this.market.getId() == null) ? 0 : this.market.getId().hashCode());
        result =
                prime
                        * result
                        + ((this.primaryIdentifier == null) ? 0 : this.primaryIdentifier.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Instrument other = (Instrument) obj;
        if (this.market.getId() == null) {
            if (other.market.getId() != null) {
                return false;
            }
        } else if (!this.market.getId().equals(other.market.getId())) {
            return false;
        }
        if (this.primaryIdentifier == null) {
            if (other.primaryIdentifier != null) {
                return false;
            }
        } else if (!this.primaryIdentifier.equals(other.primaryIdentifier)) {
            return false;
        }
        return true;
    }

}
