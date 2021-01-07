/**
 * Projeto Final - POO2021
 * @author Francisco Carreira - 2019222462
 */

package CISUC;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Investigation team.
 */
public class InvestigationTeam implements Serializable {
    private String group;
    private String acronym;
    private Investigator headLeader;
    private ArrayList<Investigator> members;
    private ArrayList<Work> works;

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
        this.works = new ArrayList<>();
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

    /**
     * Gets members.
     *
     * @return the members
     */
    public ArrayList<Investigator> getMembers() {
        Collections.sort(members);
        return members;
    }

    /**
     * Sets members.
     *
     * @param members the members
     */
    public void setMembers(ArrayList<Investigator> members) {
        this.members = members;
    }

    /**
     * Add member.
     *
     * @param investigator the investigator
     */
    public void addMember(Investigator investigator) {
        members.add(investigator);
    }

    /**
     * Remove member.
     *
     * @param investigator the investigator
     */
    public void removeMember(Investigator investigator) {
        members.remove(investigator);
    }

    /**
     * Add work.
     *
     * @param work the work
     */
    public void addWork(Work work) {
        works.add(work);
    }

    /**
     * Remove work.
     *
     * @param work the work
     */
    public void removeWork(Work work) {
        works.remove(work);
    }

    /**
     * Method to get amount of members and returning a string distinguishing between member type.
     *
     * @return String string containing the amount of members
     */
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
        return "Total count of members: " + members.size() + ", which " + students + " are students and " + efetives + " are efetive members.";
    }

    /**
     * Gets works.
     *
     * @return the works
     */
    public ArrayList<Work> getWorks() {
        Collections.sort(works);
        return works;
    }

    /**
     * Method to get amount of published papers and returning a string.
     *
     * @return String string containing the amount of published papers
     */
    private String countWorks() {
        int count = works.size();
        if (count == 0) {
            return "No published papers.";
        } else {
            int newest = 0;
            for (Work work : getWorks()) {
                if (work.getYearPublished() >= (LocalDate.now().getYear() - 5)) {
                    newest++;
                }
            }
            if (newest == 0) {
                return count + " published papers, none in the last 5 years.";
            }
            if (count == newest) {
                return count + " published papers, all in the last 5 years.";
            }
            return count + " published papers, " + newest + " in the last 5 years.";
        }
    }

    @Override
    public String toString() {
        return getAcronym() + " | " + getGroup() + " | " + getHeadLeader().getName() + " | " + countMembers() + " | " + countWorks();
    }
}
