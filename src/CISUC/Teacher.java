package CISUC;

import java.io.Serializable;

/**
 * The type Efetive member.
 */
public class Teacher extends Investigator implements Serializable {
    private String room;
    private long cellphone;

    /**
     * Instantiates a new Efetive member.
     *
     * @param name               the name
     * @param email              the email
     * @param investigationGroup the investigation group
     * @param room               the room
     * @param cellphone          the cellphone
     */
    public Teacher(String name, String email, InvestigationTeam investigationGroup, String room, long cellphone) {
        super(name, email, investigationGroup);
        this.room = room;
        this.cellphone = cellphone;
    }

    public Teacher(String name) {
        super(name);
        this.room = null;
        this.cellphone = 0;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets cellphone.
     *
     * @return the cellphone
     */
    public long getCellphone() {
        return cellphone;
    }

    /**
     * Sets cellphone.
     *
     * @param cellphone the cellphone
     */
    public void setCellphone(long cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * Create publication name string.
     *
     * @param name the name
     * @return the string
     */
    public String createPublicationName(String name) {
        String[] nameSplit = name.split(" ");
        return "Professor " + nameSplit[0] + " " + nameSplit[nameSplit.length - 1];
    }

    @Override
    public String toString() {
        return super.toString() + "\nTYPE: Teacher" +
                "\nROOM: " + room +
                "\nCELLPHONE: " + cellphone;
    }
}
