package pm.server.persistence.entity;

import java.math.BigDecimal;

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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PM_PORTFOLIO_FUNDAMENTAL", uniqueConstraints = {@UniqueConstraint(columnNames = {
        "PORTFOLIO_ID", "INSTRUMENT_ID"})})
public class PortfolioFundamental extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "SEQ_PM_PORTFOLIO_FUNDAMENTAL",
            sequenceName = "SEQ_PM_PORTFOLIO_FUNDAMENTAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PM_PORTFOLIO_FUNDAMENTAL")
    @Column(name = "PORTFOLIO_ENTRY_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PORTFOLIO_ID", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "INSTRUMENT_ID", nullable = false)
    private Instrument instrument;

    @Column(name = "TOTAL_SHARES_HELD", precision = 22, scale = 2, nullable = false)
    private BigDecimal totalSharesHeld;

    @Column(name = "COST", precision = 22, scale = 2, nullable = false)
    private BigDecimal cost;

    public PortfolioFundamental() {
        super();
        this.cost = BigDecimal.ZERO;
        this.totalSharesHeld = BigDecimal.ZERO;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Portfolio getPortfolio() {
        return this.portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Instrument getInstrument() {
        return this.instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public BigDecimal getTotalSharesHeld() {
        return this.totalSharesHeld;
    }

    public void setTotalSharesHeld(BigDecimal totalSharesHeld) {
        this.totalSharesHeld = totalSharesHeld;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.instrument == null) ? 0 : this.instrument.hashCode());
        result = prime * result + ((this.portfolio == null) ? 0 : this.portfolio.hashCode());
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
        PortfolioFundamental other = (PortfolioFundamental) obj;
        if (this.instrument == null) {
            if (other.instrument != null) {
                return false;
            }
        } else if (!this.instrument.equals(other.instrument)) {
            return false;
        }
        if (this.portfolio == null) {
            if (other.portfolio != null) {
                return false;
            }
        } else if (!this.portfolio.equals(other.portfolio)) {
            return false;
        }
        return true;
    }
}
