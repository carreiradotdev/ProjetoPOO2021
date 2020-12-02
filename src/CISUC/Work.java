package CISUC;

import java.io.Serializable;

public class Work implements Serializable {
    private String author;
    private String title;
    private String keywords;
    private int yearPublished;
    private int type;
    private int audience;
    private char impactValue;
    private String publicationName;
    private InvestigationTeam team;

    public static int TYPE_ARTICLE_CONFERENCE = 0;
    public static int TYPE_ARTICLE_MAGAZINE = 1;
    public static int TYPE_BOOK_ARTICLE_CONFERENCE = 2;
    public static int TYPE_BOOK_CHAPTER = 3;
    public static int TYPE_BOOK = 4;

    public Work(String author, String title, String keywords, InvestigationTeam team, int yearPublished, int audience) {
        this.author = author;
        this.title = title;
        this.keywords = keywords;
        this.yearPublished = yearPublished;
        this.audience = audience;
        this.impactValue = ' ';
        this.team = team;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    public char getImpactValue() {
        return impactValue;
    }

    public void setImpactValue(char impactValue) {
        this.impactValue = impactValue;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public InvestigationTeam getTeam() {
        return team;
    }

    public void setTeam(InvestigationTeam team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Work{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", yearPublished=" + yearPublished +
                ", type='" + type + '\'' +
                ", audience=" + audience +
                '}';
    }
}
