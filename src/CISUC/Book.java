package CISUC;

public class Book extends Work {
    private String editor;
    private int isbn;

    public Book(String author, String title, String keywords, int yearPublished, String type, int audience, String editor, int isbn) {
        super(author, title, keywords, yearPublished, type, audience);
        this.editor = editor;
        this.isbn = isbn;
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
