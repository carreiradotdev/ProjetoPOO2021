package CISUC;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Work.
 */
public class Work implements Serializable {
    private ArrayList<Investigator> authors;
    private String title;
    private String keywords;
    private int yearPublished;
    private int type;
    private int audience;
    private char impactValue;
    private String publicationName;
    private InvestigationTeam team;

    /**
     * The constant TYPE_ARTICLE_CONFERENCE.
     */
    public static int TYPE_ARTICLE_CONFERENCE = 0;
    /**
     * The constant TYPE_ARTICLE_MAGAZINE.
     */
    public static int TYPE_ARTICLE_MAGAZINE = 1;
    /**
     * The constant TYPE_BOOK_ARTICLE_CONFERENCE.
     */
    public static int TYPE_BOOK_ARTICLE_CONFERENCE = 2;
    /**
     * The constant TYPE_BOOK_CHAPTER.
     */
    public static int TYPE_BOOK_CHAPTER = 3;
    /**
     * The constant TYPE_BOOK.
     */
    public static int TYPE_BOOK = 4;

    /**
     * Instantiates a new Work.
     *
     * @param authors        the author
     * @param title         the title
     * @param keywords      the keywords
     * @param team          the team
     * @param yearPublished the year published
     * @param audience      the audience
     */
    public Work(ArrayList<Investigator> authors, String title, String keywords, InvestigationTeam team, int yearPublished, int audience) {
        this.authors = authors;
        this.title = title;
        this.keywords = keywords;
        this.yearPublished = yearPublished;
        this.audience = audience;
        this.impactValue = ' ';
        this.team = team;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public ArrayList<Investigator> getAuthors() {
        return authors;
    }

    /**
     * Sets author.
     *
     * @param authors the author
     */
    public void setAuthor(ArrayList<Investigator> authors) {
        this.authors = authors;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets keywords.
     *
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Sets keywords.
     *
     * @param keywords the keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Gets year published.
     *
     * @return the year published
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets year published.
     *
     * @param yearPublished the year published
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets audience.
     *
     * @return the audience
     */
    public int getAudience() {
        return audience;
    }

    /**
     * Sets audience.
     *
     * @param audience the audience
     */
    public void setAudience(int audience) {
        this.audience = audience;
    }

    /**
     * Gets impact value.
     *
     * @return the impact value
     */
    public char getImpactValue() {
        return impactValue;
    }

    /**
     * Sets impact value.
     *
     * @param impactValue the impact value
     */
    public void setImpactValue(char impactValue) {
        this.impactValue = impactValue;
    }

    /**
     * Gets publication name.
     *
     * @return the publication name
     */
    public String getPublicationName() {
        return publicationName;
    }

    /**
     * Sets publication name.
     *
     * @param publicationName the publication name
     */
    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    /**
     * Gets team.
     *
     * @return the team
     */
    public InvestigationTeam getTeam() {
        return team;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(InvestigationTeam team) {
        this.team = team;
    }

    public String printAuthors() {
        String authorsList = "";
        boolean isFirst = true;
        for (Investigator author: authors) {
            if (isFirst) {
                authorsList = author.getPublicationName();
                isFirst = false;
            } else {
                authorsList += ", " + author.getPublicationName();
            }
        }
        return authorsList;
    }

    @Override
    public String toString() {
        return  "NAME: " + title +
                "\nWRITTEN BY: " + printAuthors() +
                "\nKEYWORDS: " + keywords +
                "\nPUBLISHED IN: " + yearPublished +
                "\nIMPACT VALUE: " + impactValue;
    }
}
