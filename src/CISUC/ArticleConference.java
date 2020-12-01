package CISUC;

public class ArticleConference extends Work {
    private String conference;
    private int articleNum;
    private String location;

    public ArticleConference(String author, String title, String keywords, InvestigationTeam team, int yearPublished, int audience, String conference, int articleNum, String location) {
        super(author, title, keywords, team, yearPublished, audience);
        this.conference = conference;
        this.articleNum = articleNum;
        this.location = location;
        if (audience >= 500) setImpactValue('A');
        if (audience < 500 && audience >= 200) setImpactValue('B');
        if (audience < 500) setImpactValue('C');
        setType(0);
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

    @Override
    public String toString() {
        return "Conference{" +
                "conference='" + conference + '\'' +
                ", articleNum=" + articleNum + ", impact=" + super.getImpactValue() +
                '}';
    }
}
