package CISUC;

public class ArticleMaganize extends Work {
    private String journalName;
    private int issueNum;
    private String issueDate;

    public ArticleMaganize(String author, String title, String keywords, int yearPublished, String type, int audience, String journalName, int issueNum, String issueDate) {
        super(author, title, keywords, yearPublished, type, audience);
        this.journalName = journalName;
        this.issueNum = issueNum;
        this.issueDate = issueDate;
        if (audience >= 1000) setImpactValue('A');
        if (audience < 1000 && audience >= 500) setImpactValue('B');
        else setImpactValue('C');
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public int getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

/*    @Override
    public String toString() {
        return "ArticleMagazine{" +
                "journalName='" + journalName + '\'' +
                ", issueNum=" + issueNum +
                ", issueDate='" + issueDate + '\'' + ", impact=" + super.getImpactValue() +
                '}';
    }*/
}
