package CISUC;

public class EfetiveMember extends Investigator{
    private String room;
    private long cellphone;

    public EfetiveMember(String name, String email, String investigationGroup, String room, long cellphone) {
        super(name, email, investigationGroup);
        this.room = room;
        this.cellphone = cellphone;
        setPublicationName(createPublicationName(name));
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

    public String createPublicationName(String name) {
        String[] nameSplit = name.split(" ");
        return "Professor " + nameSplit[0] + " " + nameSplit[nameSplit.length - 1];
    }

/*    @Override
    public String toString() {
        return "EfetiveMember{" +
                "room='" + room + '\'' +
                ", cellphone=" + cellphone + ", publicationName=" + getPublicationName() +
                '}';
    }*/
}
