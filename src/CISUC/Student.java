package CISUC;

public class Student extends Investigator {
    private String thesisName;
    private String thesisDate;
    private String professor;

    public Student(String name, String email, String investigationGroup, String thesisName, String thesisDate, String professor) {
        super(name, email, investigationGroup);
        this.thesisName = thesisName;
        this.thesisDate = thesisDate;
        this.professor = professor;
        setPublicationName(createPublicationName(name));
    }

    public String getThesisName() {
        return thesisName;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName;
    }

    public String getThesisDate() {
        return thesisDate;
    }

    public void setThesisDate(String thesisDate) {
        this.thesisDate = thesisDate;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String createPublicationName(String name) {
        String[] nameSplit = name.split(" ");
        return nameSplit[0].charAt(0) + ". " + nameSplit[nameSplit.length - 1];
    }

/*    @Override
    public String toString() {
        return "Student{" +
                "thesisName='" + thesisName + '\'' +
                ", thesisDate='" + thesisDate + '\'' +
                ", professor='" + professor + '\'' +  ", publicationName=" + getPublicationName() +
                '}';
    }*/
}
