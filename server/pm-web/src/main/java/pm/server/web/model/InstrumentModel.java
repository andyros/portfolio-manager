package pm.server.web.model;

public class InstrumentModel {

    private Long id;
    private String primaryIdentifier;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return this.primaryIdentifier;
    }

    public void setIdentifier(String identifier) {
        this.primaryIdentifier = identifier;
    }
}
