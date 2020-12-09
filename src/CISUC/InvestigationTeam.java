package CISUC;

import java.io.Serializable;

/**
 * The type Investigation team.
 */
public class InvestigationTeam implements Serializable {
    private String group;
    private String acronym;
    private Investigator headLeader;

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

    @Override
    public String toString() {
        return "InvestigationTeam{" +
                "group='" + group + '\'' + ", acronym='" + acronym + '\'' +
                ", headLeader="  + headLeader + '}';
    }
}
