package apshirokov.cs.hse.iqueue;

public class BranchListElement {
    private String time;
    private String address;

    public BranchListElement(String address, String time){
        this.address = address;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }
}
