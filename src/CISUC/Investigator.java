package CISUC;

public class Investigator {
    private String name;
    private String email;
    private String investigationGroup;

    public Investigator(String name, String email, String investigationGroup) {
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

    public String getInvestigationGroup() {
        return investigationGroup;
    }

    public void setInvestigationGroup(String investigationGroup) {
        this.investigationGroup = investigationGroup;
    }

    @Override
    public String toString() {
        return "Investigator{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", investigationGroup='" + investigationGroup + '\'' +
                '}';
    }
}
