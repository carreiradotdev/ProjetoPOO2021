package CISUC;

import java.util.Date;

public class Student extends Investigator {
    private String thesisName;
    private Date thesisDate;
    private String professor;

    public Student(String name, String email, InvestigationTeam investigationGroup, String thesisName, Date thesisDate, String professor) {
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

    public Date getThesisDate() {
        return thesisDate;
    }

    public void setThesisDate(Date thesisDate) {
        this.thesisDate = thesisDate;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
