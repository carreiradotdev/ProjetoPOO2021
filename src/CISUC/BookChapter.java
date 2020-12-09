package CISUC;

import java.util.ArrayList;

/**
 * The type Book chapter.
 */
public class BookChapter extends Book {
    private String chapterName;
    private int startingPage;
    private int endingPage;

    /**
     * Instantiates a new Book chapter.
     *
     * @param author        the author
     * @param title         the title
     * @param keywords      the keywords
     * @param team          the team
     * @param yearPublished the year published
     * @param audience      the audience
     * @param editor        the editor
     * @param isbn          the isbn
     * @param chapterName   the chapter name
     * @param startingPage  the starting page
     * @param endingPage    the ending page
     */
    public BookChapter(ArrayList<Investigator> author, String title, String keywords, InvestigationTeam team, int yearPublished, int audience, String editor, int isbn, String chapterName, int startingPage, int endingPage) {
        super(author, title, keywords, team, audience, yearPublished, editor, isbn);
        this.chapterName = chapterName;
        this.startingPage = startingPage;
        this.endingPage = endingPage;
        if (audience >= 10000) setImpactValue('A');
        if (audience < 10000 && audience >= 5000) setImpactValue('B');
        if (audience < 5000) setImpactValue('C');
        setType(3);
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

    @Override
    public String toString() {
        return super.toString() +
                "\nTYPE: Book Chapter" +
                "\nCHAPTER NAME: " + chapterName +
                "\nPAGES: " + startingPage + " - " + endingPage +
                "\nIMPACT: " + super.getImpactValue();
    }
}
