package pm.server.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pm.server.persistence.entity.Portfolio;
import pm.server.persistence.entity.PortfolioFundamental;

/**
 * This class is responsible for converting our jpa entites into our 'public facing' api models.
 * Admittedly there is some duplication between the two areas but we separate them to allow for an
 * api design that isn't simply one-to-one with the entity and to allow us to refactor / grow the
 * api independently of the entities.
 */
public class ModelConverter {

    private ModelConverter() {
        super();
    }

    public static PortfolioModel toPortfolioModel(Portfolio p) {
        PortfolioModel rp = new PortfolioModel();
        rp.setId(p.getId());
        rp.setName(p.getName());
        return rp;
    }

    public static Portfolio fromPortfolioModel(PortfolioModel pm) {
        Portfolio p = new Portfolio();
        p.setId(pm.getId());
        p.setName(pm.getName());
        return p;
    }

    public static PortfolioFundamentalModel toPortfolioFundamentalModel(PortfolioFundamental pf) {
        PortfolioFundamentalModel pfm = new PortfolioFundamentalModel();
        pfm.setInstrumentId(pf.getInstrument().getId());
        pfm.setInstrumentName(pf.getInstrument().getPrimaryIdentifier());
        pfm.setPortfolioId(pf.getPortfolio().getId());
        pfm.setTotalCost(pf.getCost());
        pfm.setTotalSharesHeld(pf.getTotalSharesHeld());
        return pfm;
    }


    public static List<PortfolioFundamentalModel> toPortfolioFundamentalModel(
            Collection<PortfolioFundamental> pfs) {
        List<PortfolioFundamentalModel> models =
                new ArrayList<PortfolioFundamentalModel>(pfs.size());
        for (PortfolioFundamental pf : pfs) {
            models.add(toPortfolioFundamentalModel(pf));
        }
        return models;
    }
}
