package CISUC;

public class InvestigationTeam{
    private String group;
    private String acronym;
    private Investigator headLeader;

    public InvestigationTeam(String group, String acronym, Investigator headLeader) {
        this.group = group;
        this.acronym = acronym;
        this.headLeader = headLeader;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Investigator getHeadLeader() {
        return headLeader;
    }

    public void setHeadLeader(Investigator headLeader) {
        this.headLeader = headLeader;
    }

    @Override
    public String toString() {
        return "InvestigationTeam{" +
                "group='" + group + '\'' + ", acronym='" + acronym + '\'' +
                ", headLeader="  + '}';
    }
}
