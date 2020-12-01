package CISUC;

public class BookChapter extends Book{
    private String chapterName;
    private int startingPage;
    private int endingPage;

    public BookChapter(String author, String title, String keywords, InvestigationTeam team, int yearPublished, int audience, String editor, int isbn, String chapterName, int startingPage, int endingPage) {
        super(author, title, keywords, team, yearPublished, audience, editor, isbn);
        this.chapterName = chapterName;
        this.startingPage = startingPage;
        this.endingPage = endingPage;
        if (audience >= 10000) setImpactValue('A');
        if (audience < 10000 && audience >= 5000) setImpactValue('B');
        else setImpactValue('C');
        setType(3);
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getStartingPage() {
        return startingPage;
    }

    public void setStartingPage(int startingPage) {
        this.startingPage = startingPage;
    }

    public int getEndingPage() {
        return endingPage;
    }

    public void setEndingPage(int endingPage) {
        this.endingPage = endingPage;
    }

    @Override
    public String toString() {
        return "BookChapter{" +
                "chapterName='" + chapterName + '\'' +
                ", startingPage=" + startingPage +
                ", endingPage=" + endingPage + ", impact=" + super.getImpactValue() +
                '}';
    }
}
