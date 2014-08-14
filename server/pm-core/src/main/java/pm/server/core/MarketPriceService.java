package pm.server.core;

import java.math.BigDecimal;

public interface MarketPriceService {

    BigDecimal getCurrentPrice(Long instrumentId);
}
