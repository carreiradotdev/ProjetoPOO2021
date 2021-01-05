package CISUC;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Investigation team.
 */
public class InvestigationTeam implements Serializable {
    private String group;
    private String acronym;
    private Investigator headLeader;
    private ArrayList<Investigator> members;

    /**
     * Instantiates a new Investigation team.
     *
     * @param group      the group
     * @param acronym    the acronym
     * @param headLeader the head leader
     */
    public InvestigationTeam(String group, String acronym, Investigator headLeader) {
        this.group = group;
        this.acronym = acronym;
        this.headLeader = headLeader;
        this.members = new ArrayList<>();
    }

    /**
     * Instantiates a new Investigation team.
     *
     * @param group   the group
     * @param acronym the acronym
     */
    public InvestigationTeam(String group, String acronym) {
        this.group = group;
        this.acronym = acronym;
        this.headLeader = null;
        this.members = new ArrayList<>();
    }

    /**
     * Gets group.
     *
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets group.
     *
     * @param group the group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Gets acronym.
     *
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Sets acronym.
     *
     * @param acronym the acronym
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Gets head leader.
     *
     * @return the head leader
     */
    public Investigator getHeadLeader() {
        return headLeader;
    }

    /**
     * Sets head leader.
     *
     * @param headLeader the head leader
     */
    public void setHeadLeader(Investigator headLeader) {
        this.headLeader = headLeader;
    }

    public ArrayList<Investigator> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Investigator> members) {
        this.members = members;
    }

    public void addMember(Investigator investigator) {
        members.add(investigator);
    }

    public void removeMember(Investigator investigator) {
        members.remove(investigator);
    }

/*    public void listMembers() {
        for (Investigator member: members) {
            System.out.println("===================");
            System.out.println(member);
        }
        System.out.println("===================");
    }*/

    private String countMembers() {
        int students = 0;
        int efetives = 0;
        for (Investigator investigator : getMembers()) {
            if (investigator.getPublicationName().contains("Professor")) {
                efetives++;
            } else {
                students++;
            }
        }
        return "Total count of members: " + getMembers().size() + ", which " + students + " are students and " + efetives + " are efetive members.";
    }

    @Override
    public String toString() {
        return getAcronym() + " | " + getGroup() + " | " + getHeadLeader().getName() + " | " + countMembers();
    }
}
