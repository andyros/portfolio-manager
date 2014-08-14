package pm.server.core;

import org.junit.Test;

public class PortfolioCalculationServiceImplTest {

    @Test
    public void testRecalculate() {
        // PortfolioFundamentalRepository repo = mock(PortfolioFundamentalRepository.class);
        // PortfolioCalculationServiceImpl service = new PortfolioCalculationServiceImpl();
        // service.setPortfolioFundamentalRepository(repo);
        //
        // Instrument vod = new Instrument();
        // vod.setId(1L);
        // vod.setPrimaryIdentifier("VOD");
        //
        // Instrument gsk = new Instrument();
        // gsk.setId(2L);
        // gsk.setPrimaryIdentifier("GSK");
        //
        // Instrument bp = new Instrument();
        // bp.setId(3L);
        // bp.setPrimaryIdentifier("BP");
        //
        // Portfolio p = new Portfolio();
        // p.setId(10L);
        //
        // PortfolioFundamental vodFundamental = new PortfolioFundamental();
        // vodFundamental.setInstrument(vod);
        // vodFundamental.setPortfolio(p);
        // vodFundamental.setCost(new BigDecimal("50"));
        // vodFundamental.setTotalSharesHeld(new BigDecimal("50"));
        //
        // PortfolioFundamental gskFundamental = new PortfolioFundamental();
        // gskFundamental.setInstrument(gsk);
        // gskFundamental.setPortfolio(p);
        // gskFundamental.setCost(new BigDecimal("500"));
        // gskFundamental.setTotalSharesHeld(new BigDecimal("50"));
        //
        // when(repo.getByPortfolioIdAndInstrumentId(p.getId(), vod.getId())).thenReturn(
        // vodFundamental);
        // when(repo.getByPortfolioIdAndInstrumentId(p.getId(), gsk.getId())).thenReturn(
        // gskFundamental);
        //
        // // create new portfolio entries and recalculate the fundamentals
        // List<PortfolioEntry> newEntries = new ArrayList<PortfolioEntry>();
        // newEntries.add(newPortfolioEntry(p, "01/01/2014", "100", "1.25", Direction.BUY, vod));
        // newEntries.add(newPortfolioEntry(p, "02/01/2014", "100", "1.15", Direction.BUY, vod));
        // newEntries.add(newPortfolioEntry(p, "02/01/2014", "100", "9.89", Direction.BUY, gsk));
        // newEntries.add(newPortfolioEntry(p, "03/01/2014", "50", "10.25", Direction.SELL, gsk));
        // newEntries.add(newPortfolioEntry(p, "01/01/2014", "1000.00", "9.00", Direction.BUY, bp));
        //
        // List<PortfolioFundamental> recalculated = service.recalculateFundamentals(p, newEntries);
        // Map<Instrument, PortfolioFundamental> recalculatedMap =
        // fundamentalListToMap(recalculated);
        //
        // vodFundamental = recalculatedMap.get(vod);
        // assertNotNull(vodFundamental);
        // assertEquals("290.00", vodFundamental.getCost().toString());
        // assertEquals("250.00", vodFundamental.getTotalSharesHeld().toString());
        //
        // gskFundamental = recalculatedMap.get(gsk);
        // assertNotNull(gskFundamental);
        // assertEquals("976.50", gskFundamental.getCost().toString());
        // assertEquals("100.00", gskFundamental.getTotalSharesHeld().toString());
        //
        // PortfolioFundamental bpFundamental = recalculatedMap.get(bp);
        // assertNotNull(bpFundamental);
        // assertEquals("9000.00", bpFundamental.getCost().toString());
        // assertEquals("1000.00", bpFundamental.getTotalSharesHeld().toString());
    }
}
