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
        if (audience >= 500) setImpactValue('A');
        if (audience < 500 && audience >= 200) setImpactValue('B');
        if (audience < 500) setImpactValue('C');
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

    @Override
    public String toString() {
        return super.toString() +
                "\nTYPE: Conference Article" +
                "\nCONFERENCE: " + conference +
                "\nARTICLE NUMBER: " + articleNum;
    }
}
