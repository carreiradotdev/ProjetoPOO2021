package CISUC;

import java.util.Date;

public class Student extends Investigator {
    private String thesisName;
    private String thesisDate;
    private String professor;

    public Student(String name, String email, String investigationGroup, String thesisName, String thesisDate, String professor) {
        super(name, email, investigationGroup);
        this.thesisName = thesisName;
        this.thesisDate = thesisDate;
        this.professor = professor;
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

    @Override
    public String toString() {
        return "Student{" +
                "thesisName='" + thesisName + '\'' +
                ", thesisDate='" + thesisDate + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
