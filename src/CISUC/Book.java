package CISUC;

public class Book extends Work {
    private String editor;
    private int isbn;

    public Book(String author, String title, String keywords, InvestigationTeam team, int yearPublished, int audience, String editor, int isbn) {
        super(author, title, keywords, team, audience, yearPublished);
        this.editor = editor;
        this.isbn = isbn;
        if (audience >= 10000) setImpactValue('A');
        if (audience < 10000 && audience >= 5000) setImpactValue('B');
        if (audience < 5000) setImpactValue('C');
        setType(4);
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "editor='" + editor + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
