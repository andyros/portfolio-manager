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

import pm.server.persistence.dao.PortfolioRepository;
import pm.server.persistence.entity.Portfolio;
import pm.server.web.model.PortfolioModel;

@RestController
@RequestMapping("/service/portfolio")
public class PortfolioController extends AbstractEntityToModelController<Portfolio, PortfolioModel> {

    @Resource
    private PortfolioRepository portfolioRepository;

    public PortfolioController() {
        super(Portfolio.class, PortfolioModel.class);
    }

    @Override
    protected JpaRepository<Portfolio, Long> getRepository() {
        return this.portfolioRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<PortfolioModel> createPortfolio(@RequestBody PortfolioModel pm,
            UriComponentsBuilder builder) {

        Portfolio p = new Portfolio();
        p.setName(pm.getName());
        this.portfolioRepository.save(p);

        HttpHeaders headers = new HttpHeaders();
        URI newUri = builder.path("/service/portfolio/{id}").buildAndExpand(p.getId()).toUri();
        headers.setLocation(newUri);

        PortfolioModel persistedPM = this.modelConvertor.entityToModel(p, PortfolioModel.class);
        return new ResponseEntity<>(persistedPM, headers, HttpStatus.CREATED);
    }
}
