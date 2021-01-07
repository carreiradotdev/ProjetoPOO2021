/**
 * Projeto Final - POO2021
 * @author Francisco Carreira - 2019222462
 */

package CISUC;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Book.
 */
public class Book extends Work {
    private String editor;
    private int isbn;

    /**
     * Instantiates a new Book.
     *
     * @param authors       the author
     * @param title         the title
     * @param keywords      the keywords
     * @param yearPublished the year published
     * @param audience      the audience
     * @param editor        the editor
     * @param isbn          the isbn
     */
    public Book(ArrayList<Investigator> authors, String title, String[] keywords, int yearPublished, int audience, String editor, int isbn) {
        super(authors, title, keywords, audience, yearPublished);
        this.editor = editor;
        this.isbn = isbn;
        setType(2);
        Collections.sort(authors);
    }

    /**
     * Gets editor.
     *
     * @return the editor
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Sets editor.
     *
     * @param editor the editor
     */
    public void setEditor(String editor) {
        this.editor = editor;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Sets impact value char according to object type.
     *
     * @param audience the audience amount
     */
    public char setImpactValue(int audience) {
        if (audience >= 10000) {
            return 'A';
        } else if (audience < 5000) {
            return 'C';
        } else {
            return 'B';
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEDITOR: " + editor +
                "\nISBN: " + isbn +
                "\nTYPE: Book";
    }
}
