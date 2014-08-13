package pm.server.web.model;

import java.math.BigDecimal;

public class PortfolioFundamentalModel {

    private Long portfolioId;
    private Long instrumentId;
    private String instrumentName;
    private BigDecimal currentPrice;
    private BigDecimal totalSharesHeld;
    private BigDecimal totalCost;
    private BigDecimal marketValue;
    private BigDecimal gainLoss;
    private BigDecimal gainLossPerc;

    public Long getPortfolioId() {
        return this.portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

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

    public BigDecimal getMarketValue() {
        return this.marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public BigDecimal getGainLoss() {
        return this.gainLoss;
    }

    public void setGainLoss(BigDecimal gainLoss) {
        this.gainLoss = gainLoss;
    }

    public BigDecimal getGainLossPerc() {
        return this.gainLossPerc;
    }

    public void setGainLossPerc(BigDecimal gainLossPerc) {
        this.gainLossPerc = gainLossPerc;
    }
}
