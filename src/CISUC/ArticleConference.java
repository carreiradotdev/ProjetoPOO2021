package CISUC;

import java.util.ArrayList;

public class ArticleConference extends Work {
    private String conference;
    private int articleNum;
    private String location;

    public ArticleConference(ArrayList<Investigator> authors, String title, String keywords, InvestigationTeam team, int yearPublished, int audience, String conference, int articleNum, String location) {
        super(authors, title, keywords, team, yearPublished, audience);
        this.conference = conference;
        this.articleNum = articleNum;
        this.location = location;
        setType(2);
        articleConferenceCount++;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
        return super.toString() +
                "\nTYPE: Conference Article" +
                "\nCONFERENCE: " + conference +
                "\nARTICLE NUMBER: " + articleNum;
    }
}
