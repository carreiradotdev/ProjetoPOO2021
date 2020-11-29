package CISUC;

public class Investigator {
    private String name;
    private String email;
    private InvestigationTeam investigationGroup;

    public Investigator(String name, String email, InvestigationTeam investigationGroup) {
        this.name = name;
        this.email = email;
        this.investigationGroup = investigationGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InvestigationTeam getInvestigationGroup() {
        return investigationGroup;
    }

    public void setInvestigationGroup(InvestigationTeam investigationGroup) {
        this.investigationGroup = investigationGroup;
    }
}
