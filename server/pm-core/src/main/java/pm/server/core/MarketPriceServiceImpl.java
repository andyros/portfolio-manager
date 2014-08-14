package pm.server.core;

import java.math.BigDecimal;

public class MarketPriceServiceImpl implements MarketPriceService {

    @Override
    public BigDecimal getCurrentPrice(Long instrumentId) {
        return BigDecimal.TEN;
    }

}
