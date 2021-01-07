package CISUC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Work.
 */
public abstract class Work implements Serializable, Comparable<Work> {
    private ArrayList<Investigator> authors;
    private String title;
    private String[] keywords;
    private int yearPublished;
    private int type;
    private int audience;
    private char impactValue;

    /**
     * Instantiates a new Work.
     *  @param authors       the author
     * @param title         the title
     * @param keywords      the keywords
     * @param yearPublished the year published
     * @param audience      the audience
     */
    public Work(ArrayList<Investigator> authors, String title, String[] keywords, int yearPublished, int audience) {
        this.authors = authors;
        this.title = title;
        this.keywords = keywords;
        this.yearPublished = yearPublished;
        this.audience = audience;
        this.impactValue = setImpactValue(audience);
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
    public String[] getKeywords() {
        return keywords;
    }

    /**
     * Sets keywords.
     *
     * @param keywords the keywords
     */
    public void setKeywords(String[] keywords) {
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
     * @param audience the audience value
     */
    public abstract char setImpactValue(int audience);

    public String printAuthors() {
        String authorsList = "";
        boolean isFirst = true;
        for (Investigator author : authors) {
            if (isFirst) {
                authorsList = author.getPublicationName();
                isFirst = false;
            } else {
                authorsList += ", " + author.getPublicationName();
            }
        }
        return authorsList;
    }

    public int compareTo(Work work) {
        if (this.getYearPublished() > work.getYearPublished()) {
            return -1;
        } else if (this.getYearPublished() < work.getYearPublished()) {
            return 1;
        } else {
            if (this.getImpactValue() < work.getImpactValue()) {
                return -1;
            } else if (this.getImpactValue() > work.getImpactValue()) {
                return 1;
            } else {
                if (this.getType() > work.getType()) {
                    return -1;
                } else if (this.getType() < work.getType()) {
                    return 1;
                }
            }
        }
        return getTitle().compareTo(work.title);
    }

    @Override
    public String toString() {
        return "NAME: " + title +
                "\nWRITTEN BY: " + printAuthors() +
                "\nKEYWORDS: " + Arrays.toString(keywords) +
                "\nPUBLISHED IN: " + yearPublished +
                "\nIMPACT VALUE: " + impactValue;
    }
}
