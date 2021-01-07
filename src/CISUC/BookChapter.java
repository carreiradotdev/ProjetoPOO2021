package CISUC;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Book chapter.
 */
public class BookChapter extends Book {
    private String chapterName;
    private int startingPage;
    private int endingPage;

    /**
     * Instantiates a new Book chapter.
     * @param authors        the authors
     * @param title         the title
     * @param keywords      the keywords
     * @param yearPublished the year published
     * @param audience      the audience
     * @param editor        the editor
     * @param isbn          the isbn
     * @param chapterName   the chapter name
     * @param startingPage  the starting page
     * @param endingPage    the ending page
     */
    public BookChapter(ArrayList<Investigator> authors, String title, String[] keywords, int yearPublished, int audience, String editor, int isbn, String chapterName, int startingPage, int endingPage) {
        super(authors, title, keywords, audience, yearPublished, editor, isbn);
        this.chapterName = chapterName;
        this.startingPage = startingPage;
        this.endingPage = endingPage;
        setType(3);
        Collections.sort(authors);
    }

    /**
     * Gets chapter name.
     *
     * @return the chapter name
     */
    public String getChapterName() {
        return chapterName;
    }

    /**
     * Sets chapter name.
     *
     * @param chapterName the chapter name
     */
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    /**
     * Gets starting page.
     *
     * @return the starting page
     */
    public int getStartingPage() {
        return startingPage;
    }

    /**
     * Sets starting page.
     *
     * @param startingPage the starting page
     */
    public void setStartingPage(int startingPage) {
        this.startingPage = startingPage;
    }

    /**
     * Gets ending page.
     *
     * @return the ending page
     */
    public int getEndingPage() {
        return endingPage;
    }

    /**
     * Sets ending page.
     *
     * @param endingPage the ending page
     */
    public void setEndingPage(int endingPage) {
        this.endingPage = endingPage;
    }

    /**
     * Sets impact value char according to object type.
     *
     * @param audience the audience amount
     */
    public char setImpactValue(int audience) {
        if (audience >= 10000) {
            return 'A';
        } else if (audience < 5000) {
            return 'C';
        } else {
            return 'B';
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSUBTYPE: Book Chapter" +
                "\nCHAPTER NAME: " + chapterName +
                "\nPAGES: " + startingPage + " - " + endingPage;
    }
}
