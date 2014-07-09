package pm.server.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pm.server.persistence.entity.Portfolio;

@RestController
@RequestMapping("/service/portfolio")
public class PortfolioController {

    @RequestMapping("/")
    public List<Portfolio> getAll() {
        Portfolio p = new Portfolio();
        p.setId(Long.valueOf(5));
        p.setName("Portfolio From Server!");

        List<Portfolio> all = new ArrayList<>();
        all.add(p);
        return all;
    }

    @RequestMapping("/{id}")
    public Portfolio getById(@PathVariable Long id) {
        Portfolio p = new Portfolio();
        p.setId(Long.valueOf(5));
        p.setName("Portfolio From Server!");
        return p;
    }
}
