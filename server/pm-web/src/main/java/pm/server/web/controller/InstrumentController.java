package pm.server.web.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pm.server.core.InstrumentSearchService;
import pm.server.persistence.dao.InstrumentRepository;
import pm.server.persistence.entity.Instrument;
import pm.server.web.model.InstrumentModel;

@RestController
@RequestMapping("/service/instrument")
public class InstrumentController extends
        AbstractEntityToModelController<Instrument, InstrumentModel> {

    @Resource
    private InstrumentRepository instrumentRepository;

    @Resource
    private InstrumentSearchService instrumentSearchService;

    public InstrumentController() {
        super(Instrument.class, InstrumentModel.class);
    }

    @Override
    protected JpaRepository<Instrument, Long> getRepository() {
        return this.instrumentRepository;
    }

    @RequestMapping("/search")
    public List<InstrumentModel> findInstruments(@RequestParam("text") String text) {
        Collection<Instrument> matches = this.instrumentSearchService.findInstruments(text);
        return this.modelConvertor.convert(matches, InstrumentModel.class);
    }
}
