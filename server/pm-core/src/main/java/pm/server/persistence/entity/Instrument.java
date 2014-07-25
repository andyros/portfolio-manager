package pm.server.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PM_INSTRUMENT", uniqueConstraints = {@UniqueConstraint(
        columnNames = "PRIMARY_IDENTIFIER")})
public class Instrument extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "SEQ_PM_INSTRUMENT", sequenceName = "SEQ_PM_INSTRUMENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PM_INSTRUMENT")
    @Column(name = "INSTRUMENT_ID", nullable = false)
    private Long id;

    @Column(name = "PRIMARY_IDENTIFIER", nullable = false)
    private String primaryIdentifier;

    public Instrument() {
        super();
    }

    public Instrument(String primaryIdentifier) {
        super();
        this.primaryIdentifier = primaryIdentifier;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryIdentifier() {
        return this.primaryIdentifier;
    }

    public void setPrimaryIdentifier(String primaryIdentifier) {
        this.primaryIdentifier = primaryIdentifier;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
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
