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
@Table(name = "PM_PORTFOLIO", uniqueConstraints = {@UniqueConstraint(columnNames = "NAME")})
public class Portfolio extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "SEQ_PM_PORTFOLIO", sequenceName = "SEQ_PM_PORTFOLIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PM_PORTFOLIO")
    @Column(name = "PORTFOLIO_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Portfolio() {
        super();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
        Portfolio other = (Portfolio) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Portfolio [id=" + this.id + ", name=" + this.name + "]";
    }
}
