package pm.server.web.controller;

import java.net.URI;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pm.server.persistence.dao.InstrumentRepository;
import pm.server.persistence.dao.PortfolioEntryRepository;
import pm.server.persistence.dao.PortfolioRepository;
import pm.server.persistence.entity.Instrument;
import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioEntry;
import pm.server.web.model.PortfolioEntryModel;

@RestController
@RequestMapping("/service/portfolio/entry")
public class PortfolioEntryController extends
        AbstractEntityToModelController<PortfolioEntry, PortfolioEntryModel> {

    @Resource
    private PortfolioRepository portfolioRepository;

    @Resource
    private PortfolioEntryRepository portfolioEntryRepository;

    @Resource
    private InstrumentRepository instrumentRepository;

    public PortfolioEntryController() {
        super(PortfolioEntry.class, PortfolioEntryModel.class);
    }

    @Override
    protected JpaRepository<PortfolioEntry, Long> getRepository() {
        return this.portfolioEntryRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<PortfolioEntryModel> createPortfolioEntry(
            @RequestBody PortfolioEntryModel pm, UriComponentsBuilder builder) {

        Portfolio p = this.portfolioRepository.getOne(pm.getPortfolioId());
        Instrument i = this.instrumentRepository.getOne(pm.getInstrumentId());
        if (p == null || i == null) {
            // TODO
            throw new IllegalStateException();
        }

        PortfolioEntry pe = new PortfolioEntry();
        pe.setDirection(pm.getDirection());
        pe.setInstrument(i);
        pe.setPortfolio(p);
        pe.setPrice(pm.getPrice());
        pe.setQuantity(pm.getQuantity());
        this.portfolioEntryRepository.save(pe);

        HttpHeaders headers = new HttpHeaders();
        URI newUri =
                builder.path("/service/portfolio/entry/{id}").buildAndExpand(pe.getId()).toUri();
        headers.setLocation(newUri);

        PortfolioEntryModel persistedPM =
                this.modelConvertor.entityToModel(pe, PortfolioEntryModel.class);
        return new ResponseEntity<>(persistedPM, headers, HttpStatus.CREATED);
    }
}
