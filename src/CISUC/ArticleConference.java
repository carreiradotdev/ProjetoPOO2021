package CISUC;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Article conference.
 */
public class ArticleConference extends Work {
    private String conference;
    private int articleNum;
    private String location;

    /**
     * Instantiates a new Article conference.
     *
     * @param authors       the authors
     * @param title         the title
     * @param keywords      the keywords
     * @param yearPublished the year published
     * @param audience      the audience
     * @param conference    the conference
     * @param articleNum    the article num
     * @param location      the location
     */
    public ArticleConference(ArrayList<Investigator> authors, String title, String[] keywords, int yearPublished, int audience, String conference, int articleNum, String location) {
        super(authors, title, keywords, yearPublished, audience);
        this.conference = conference;
        this.articleNum = articleNum;
        this.location = location;
        setType(0);
        Collections.sort(authors); //sorts works' authors.
    }

    /**
     * Gets conference.
     *
     * @return the conference
     */
    public String getConference() {
        return conference;
    }

    /**
     * Sets conference.
     *
     * @param conference the conference
     */
    public void setConference(String conference) {
        this.conference = conference;
    }

    /**
     * Gets article num.
     *
     * @return the article num
     */
    public int getArticleNum() {
        return articleNum;
    }

    /**
     * Sets article num.
     *
     * @param articleNum the article num
     */
    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets impact value char according to object type.
     *
     * @param audience the audience amount
     */
    public char setImpactValue(int audience) {
        if (audience >= 500) {
            return 'A';
        } else if (audience < 200) {
            return 'C';
        } else {
            return 'B';
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nTYPE: Conference Article" +
                "\nCONFERENCE: " + conference +
                "\nARTICLE NUMBER: " + articleNum;
    }
}
