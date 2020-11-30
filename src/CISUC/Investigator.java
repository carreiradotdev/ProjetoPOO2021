package CISUC;

public class Investigator {
    private String name;
    private String email;
    private String investigationGroup;
    private String publicationName;
    private int type;

    public static int TYPE_STUDENT = 0;
    public static int TYPE_EFETIVE = 1;

    public Investigator(String name, String email, String investigationGroup) {
        this.name = name;
        this.email = email;
        this.investigationGroup = investigationGroup;
        this.publicationName = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvestigationGroup() {
        return investigationGroup;
    }

    public void setInvestigationGroup(String investigationGroup) {
        this.investigationGroup = investigationGroup;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Investigator{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", investigationGroup='" + investigationGroup + '\'' + ", publication='" + publicationName + '\'' +
                '}';
    }
}
