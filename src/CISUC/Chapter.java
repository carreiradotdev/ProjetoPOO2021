package CISUC;

public class Chapter extends Book{
    private String chapterName;
    private int startingPage;
    private int endingPage;

    public Chapter(String author, String title, String keywords, int yearPublished, String type, int audience, String editor, int isbn, String chapterName, int startingPage, int endingPage) {
        super(author, title, keywords, yearPublished, type, audience, editor, isbn);
        this.chapterName = chapterName;
        this.startingPage = startingPage;
        this.endingPage = endingPage;
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
        return "Chapter{" +
                "chapterName='" + chapterName + '\'' +
                ", startingPage=" + startingPage +
                ", endingPage=" + endingPage +
                '}';
    }
}
