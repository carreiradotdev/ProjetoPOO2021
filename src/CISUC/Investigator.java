package CISUC;

import java.io.Serializable;

/**
 * The type Investigator.
 */
public class Investigator implements Serializable {
    private String name;
    private String email;
    private InvestigationTeam investigationGroup;
    private String publicationName;
    private String type;

    /**
     * The constant TYPE_STUDENT.
     */
    public static String TYPE_STUDENT = "Student";
    /**
     * The constant TYPE_EFETIVE.
     */
    public static String TYPE_TEACHER= "Teacher";

    public static int studentCount = 0;
    public static int teacherCount = 0;

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
        this.publicationName = "";
    }

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
        this.email = email;
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

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    //TODO: public abstract String createPublicationName(String name);

    @Override
    public String toString() {
        return "NAME: " + name + "\nEMAIL: " + email + "\nINVESTIGATION GROUP: " + investigationGroup.getGroup();
    }
}
