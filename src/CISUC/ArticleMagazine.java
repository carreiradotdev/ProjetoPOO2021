/**
 * Projeto Final - POO2021
 * @author Francisco Carreira - 2019222462
 */

package CISUC;

import java.util.ArrayList;
import java.util.Collections;

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
     * @param authors        the author
     * @param title         the title
     * @param keywords      the keywords
     * @param yearPublished the year published
     * @param audience      the audience
     * @param journalName   the journal name
     * @param issueNum      the issue num
     * @param issueDate     the issue date
     */
    public ArticleMagazine(ArrayList<Investigator> authors, String title, String[] keywords, int yearPublished, int audience, String journalName, int issueNum, String issueDate) {
        super(authors, title, keywords, yearPublished, audience);
        this.journalName = journalName;
        this.issueNum = issueNum;
        this.issueDate = issueDate;
        setType(1);
        Collections.sort(authors);
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

    /**
     * Sets impact value char according to object type.
     *
     * @param audience the audience amount
     */
    public char setImpactValue(int audience) {
        if (audience >= 1000) {
            return 'A';
        } else if (audience < 500) {
            return 'C';
        } else {
            return 'B';
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTYPE: Magazine Article" +
                "\nJOURNAL NAME: " + journalName +
                "\nISSUE NO:" + issueNum +
                "\nISSUE DATE: " + issueDate;
    }
}
