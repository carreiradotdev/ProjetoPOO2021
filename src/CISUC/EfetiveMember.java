package CISUC;

public class EfetiveMember extends Investigator{
    private String room;
    private long cellphone;

    public EfetiveMember(String name, String email, InvestigationTeam investigationGroup, String room, long cellphone) {
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
}
