package CISUC;

import org.jetbrains.annotations.NotNull;

public class EfetiveMember extends Investigator{
    private String room;
    private long cellphone;

    public EfetiveMember(String name, String email, String investigationGroup, String room, long cellphone) {
        super(name, email, investigationGroup);
        this.room = room;
        this.cellphone = cellphone;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public long getCellphone() {
        return cellphone;
    }

    public void setCellphone(long cellphone) {
        this.cellphone = cellphone;
    }

    public String getPublicationName(@NotNull String name) {
        String[] nameSplit = name.split(" ");
        String publicationName = "Professor " + nameSplit[0] + " " + nameSplit[-1];
        return publicationName;
    }

    @Override
    public String toString() {
        return "EfetiveMember{" +
                "room='" + room + '\'' +
                ", cellphone=" + cellphone +
                '}';
    }
}
