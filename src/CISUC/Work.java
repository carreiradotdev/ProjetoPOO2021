package CISUC;

import java.util.ArrayList;

public class Work {
    private String author;
    private String title;
    private String keywords;
    private int yearPublished;
    private String type;
    private int audience;
    private char impactValue;
    private String publicationName;

    public Work(String author, String title, String keywords, int yearPublished, String type, int audience) {
        this.author = author;
        this.title = title;
        this.keywords = keywords;
        this.yearPublished = yearPublished;
        this.type = type;
        this.audience = audience;
        this.impactValue = ' ';
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public void setPubName(Investigator investigator) {
        this.publicationName = investigator.getPublicationName();
    }

    public String getPublicationName() {
        return publicationName;
    }

    @Override
    public String toString() {
        return "Work{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", yearPublished=" + yearPublished +
                ", type='" + type + '\'' +
                ", audience=" + audience + ", publication=" + publicationName +
                '}';
    }
}
