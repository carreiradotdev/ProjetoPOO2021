package CISUC;

public class BookArticleConference extends Book {
    private String conferenceName;
    private int articleNum;
    private int count;

    public BookArticleConference(String author, String title, String keywords, int yearPublished, String type, int audience, String editor, int isbn, String conferenceName, int articleNum) {
        super(author, title, keywords, yearPublished, type, audience, editor, isbn);
        this.conferenceName = conferenceName;
        this.articleNum = articleNum;
        if (audience >= 7500) setImpactValue('A');
        if (audience < 75000 && audience >= 2500) setImpactValue('B');
        else setImpactValue('C');
        count++;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ConferenceArticleBook{" +
                "conferenceName='" + conferenceName + '\'' +
                ", articleNum=" + articleNum +
                '}';
    }
}
