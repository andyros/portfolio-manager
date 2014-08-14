package pm.server.web.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pm.server.core.PortfolioCalculationService;
import pm.server.core.dto.PortfolioFundamental;
import pm.server.persistence.dao.PortfolioEntryRepository;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.web.model.PortfolioFundamentalModel;
import pm.server.web.model.conversion.ModelConvertor;

@RestController
@RequestMapping("/service/portfolio/fundamental")
public class PortfolioFundamentalController {

    @Resource
    private ModelConvertor modelConvertor;

    @Resource
    private PortfolioCalculationService portfolioCalculationService;

    @Resource
    private PortfolioEntryRepository portfolioEntryRepository;

    @RequestMapping("/{portfolioId}")
    public Collection<PortfolioFundamentalModel> findByPortfolioId(@PathVariable Long portfolioId) {
        List<PortfolioEntry> entries = this.portfolioEntryRepository.findByPortfolioId(portfolioId);
        if (entries.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Instrument, PortfolioFundamental> fundamentals =
                this.portfolioCalculationService.recalculateFundamentals(entries);

        return this.modelConvertor.convert(fundamentals.values(), PortfolioFundamentalModel.class);
    }
}
