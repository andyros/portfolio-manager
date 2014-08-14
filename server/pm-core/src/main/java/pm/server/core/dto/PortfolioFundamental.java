package pm.server.core.dto;

import java.math.BigDecimal;

import pm.server.persistence.entity.Instrument;

public class PortfolioFundamental {

    private Instrument instrument;
    private BigDecimal currentPrice;

    private BigDecimal totalSharesHeld;
    private BigDecimal totalCost;
    private BigDecimal marketCost;

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

    public BigDecimal getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getCurrentPrice() {
        return this.currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getMarketCost() {
        return this.marketCost;
    }

    public void setMarketCost(BigDecimal marketCost) {
        this.marketCost = marketCost;
    }
}
