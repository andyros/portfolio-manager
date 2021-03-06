package pm.server.web.model;

import java.math.BigDecimal;

public class PortfolioFundamentalModel {

    private Long instrumentId;
    private String instrumentName;
    private BigDecimal currentPrice;

    private BigDecimal totalSharesHeld;
    private BigDecimal totalCost;
    private BigDecimal marketCost;

    public Long getInstrumentId() {
        return this.instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return this.instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public BigDecimal getCurrentPrice() {
        return this.currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
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

    public BigDecimal getMarketCost() {
        return this.marketCost;
    }

    public void setMarketCost(BigDecimal marketCost) {
        this.marketCost = marketCost;
    }
}
