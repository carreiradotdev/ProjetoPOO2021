package CISUC;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Book article conference.
 */
public class BookArticleConference extends Book {
    private String conferenceName;
    private int articleNum;
    private int count;

    /**
     * Instantiates a new Book article conference.
     * @param authors         the author
     * @param title          the title
     * @param keywords       the keywords
     * @param yearPublished  the year published
     * @param audience       the audience
     * @param editor         the editor
     * @param isbn           the isbn
     * @param conferenceName the conference name
     * @param articleNum     the article num
     */
    public BookArticleConference(ArrayList<Investigator> authors, String title, String[] keywords, int yearPublished, int audience, String editor, int isbn, String conferenceName, int articleNum) {
        super(authors, title, keywords, audience,yearPublished, editor, isbn);
        this.conferenceName = conferenceName;
        this.articleNum = articleNum;
        setType(4);
        Collections.sort(authors);
    }

    /**
     * Gets conference name.
     *
     * @return the conference name
     */
    public String getConferenceName() {
        return conferenceName;
    }

    /**
     * Sets conference name.
     *
     * @param conferenceName the conference name
     */
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    /**
     * Gets article number.
     *
     * @return the article number
     */
    public int getArticleNum() {
        return articleNum;
    }

    /**
     * Sets article number.
     *
     * @param articleNum the article number
     */
    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Sets impact value char according to object type.
     *
     * @param audience the audience amount
     */
    public char setImpactValue(int audience) {
        if (audience >= 7500) {
            return 'A';
        } else if (audience < 2500) {
            return 'C';
        } else {
            return 'B';
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSUBTYPE: Conference Article Book" +
                "\nCONFERENCE NAME: " + conferenceName +
                "\nARTICLE NUMBER: " + articleNum;
    }
}
