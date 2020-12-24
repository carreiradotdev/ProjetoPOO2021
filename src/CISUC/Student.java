package CISUC;

import java.io.Serializable;

/**
 * The type Student.
 */
public class Student extends Investigator implements Serializable {
    private String thesisName;
    private String thesisDate;
    private String professor;

    /**
     * Instantiates a new Student.
     *
     * @param name               the name
     * @param email              the email
     * @param investigationGroup the investigation group
     * @param thesisName         the thesis name
     * @param thesisDate         the thesis date
     * @param professor          the professor
     */
    public Student(String name, String email, InvestigationTeam investigationGroup, String thesisName, String thesisDate, String professor) {
        super(name, email, investigationGroup);
        this.thesisName = thesisName;
        this.thesisDate = thesisDate;
        this.professor = professor;
        setPublicationName(createPublicationName(name));
        studentCount++;
    }

    /**
     * Gets thesis name.
     *
     * @return the thesis name
     */
    public String getThesisName() {
        return thesisName;
    }

    /**
     * Sets thesis name.
     *
     * @param thesisName the thesis name
     */
    public void setThesisName(String thesisName) {
        this.thesisName = thesisName;
    }

    /**
     * Gets thesis date.
     *
     * @return the thesis date
     */
    public String getThesisDate() {
        return thesisDate;
    }

    /**
     * Sets thesis date.
     *
     * @param thesisDate the thesis date
     */
    public void setThesisDate(String thesisDate) {
        this.thesisDate = thesisDate;
    }

    /**
     * Gets professor.
     *
     * @return the professor
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * Sets professor.
     *
     * @param professor the professor
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * Create publication name string.
     *
     * @param name the name
     * @return the string
     */
    public String createPublicationName(String name) {
        String[] nameSplit = name.split(" ");
        return nameSplit[0].charAt(0) + ". " + nameSplit[nameSplit.length - 1];
    }

 @Override
    public String toString() {
        return super.toString() + "\nTYPE: Student" +
                "\nTHESIS NAME: " + thesisName +
                "\nTHESIS DUE DATE: " + thesisDate +
                "\nPROFESSOR IN CHARGE: " + professor;
    }
}
