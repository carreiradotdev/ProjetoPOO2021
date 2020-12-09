package CISUC;

import java.util.ArrayList;

/**
 * The type Article magazine.
 */
public class ArticleMagazine extends Work {
    private String journalName;
    private int issueNum;
    private String issueDate;

    /**
     * Instantiates a new Article magazine.
     *
     * @param author        the author
     * @param title         the title
     * @param keywords      the keywords
     * @param team          the team
     * @param yearPublished the year published
     * @param audience      the audience
     * @param journalName   the journal name
     * @param issueNum      the issue num
     * @param issueDate     the issue date
     */
    public ArticleMagazine(ArrayList<Investigator> author, String title, String keywords, InvestigationTeam team, int yearPublished, int audience, String journalName, int issueNum, String issueDate) {
        super(author, title, keywords, team, yearPublished, audience);
        this.journalName = journalName;
        this.issueNum = issueNum;
        this.issueDate = issueDate;
        if (audience >= 1000) setImpactValue('A');
        if (audience < 1000 && audience >= 500) setImpactValue('B');
        if (audience < 500) setImpactValue('C');
        setType(1);
    }

    /**
     * Gets journal name.
     *
     * @return the journal name
     */
    public String getJournalName() {
        return journalName;
    }

    /**
     * Sets journal name.
     *
     * @param journalName the journal name
     */
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    /**
     * Gets issue num.
     *
     * @return the issue num
     */
    public int getIssueNum() {
        return issueNum;
    }

    /**
     * Sets issue num.
     *
     * @param issueNum the issue num
     */
    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }

    /**
     * Gets issue date.
     *
     * @return the issue date
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Sets issue date.
     *
     * @param issueDate the issue date
     */
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

@Override
    public String toString() {
        return "| year | type | impact value | author | title |";
    }
}
