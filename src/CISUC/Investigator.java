/**
 * Projeto Final - POO2021
 * @author Francisco Carreira - 2019222462
 */

package CISUC;

import java.io.Serializable;

/**
 * The type Investigator.
 */
public abstract class Investigator implements Serializable, Comparable<Investigator> {
    private String name;
    private String email;
    private InvestigationTeam investigationGroup;
    private String publicationName;
    private int priority;

    /**
     * Instantiates a new Investigator.
     *
     * @param name               the name
     * @param email              the email
     * @param investigationGroup the investigation group
     */
    public Investigator(String name, String email, InvestigationTeam investigationGroup) {
        this.name = name;
        this.email = email;
        this.investigationGroup = investigationGroup;
        this.publicationName = createPublicationName(name);
    }

    public Investigator(String name) {
        this.name = name;
        this.email = null;
        this.investigationGroup = null;
        this.publicationName = createPublicationName(name);
    }

    public abstract String createPublicationName(String name);

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        if (email.contains("@")) this.email = email;
    }

    /**
     * Gets investigation group.
     *
     * @return the investigation group
     */
    public InvestigationTeam getInvestigationGroup() {
        return investigationGroup;
    }

    /**
     * Sets investigation group.
     *
     * @param investigationGroup the investigation group
     */
    public void setInvestigationGroup(InvestigationTeam investigationGroup) {
        this.investigationGroup = investigationGroup;
    }

    /**
     * Gets publication name.
     *
     * @return the publication name
     */
    public String getPublicationName() {
        return publicationName;
    }

    /**
     * Sets publication name.
     *
     * @param publicationName the publication name
     */
    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Gets priority.
     *
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Compares this object with the specified object for order.
     *
     * @return Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    public int compareTo(Investigator investigator) {
        if (this.getPriority() < investigator.getPriority()) {
            return 1;
        } else if (this.getPriority() > investigator.getPriority()) {
            return -1;
        } else {
            return getName().compareTo(investigator.getName());
        }
    }

    @Override
    public String toString() {
        return "NAME: " + name + "\nEMAIL: " + email + "\nINVESTIGATION GROUP: " + investigationGroup.getGroup();
    }
}
