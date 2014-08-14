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
import pm.server.persistence.entity.Instrument;
import pm.server.web.model.InstrumentModel;

@RestController
@RequestMapping("/service/instrument")
public class InstrumentController extends AbstractEntityToModelController<Instrument, InstrumentModel> {

    @Resource
    private InstrumentRepository instrumentRepository;

    public InstrumentController() {
        super(Instrument.class, InstrumentModel.class);
    }

    @Override
    protected JpaRepository<Instrument, Long> getRepository() {
        return this.instrumentRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<InstrumentModel> createPortfolio(@RequestBody InstrumentModel pm,
            UriComponentsBuilder builder) {

        Instrument i = new Instrument();
        i.setPrimaryIdentifier(pm.getIdentifier());
        this.instrumentRepository.save(i);

        HttpHeaders headers = new HttpHeaders();
        URI newUri = builder.path("/service/instrument/{id}").buildAndExpand(i.getId()).toUri();
        headers.setLocation(newUri);

        InstrumentModel persistedIns = this.modelConvertor.entityToModel(i, InstrumentModel.class);
        return new ResponseEntity<>(persistedIns, headers, HttpStatus.CREATED);
    }
}
