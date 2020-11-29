package CISUC;

public class Conference extends Work {
    private String conference;
    private int articleNum;

    public Conference(String author, String title, String keywords, int yearPublished, String type, int audience, String conference, int articleNum) {
        super(author, title, keywords, yearPublished, type, audience);
        this.conference = conference;
        this.articleNum = articleNum;
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
                ", articleNum=" + articleNum +
                '}';
    }
}
