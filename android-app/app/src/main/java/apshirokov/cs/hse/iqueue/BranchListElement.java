package apshirokov.cs.hse.iqueue;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BranchListElement {
    @SerializedName("waitingTime")
    private Date time;
    @SerializedName("address")
    private String address;

    public BranchListElement(String address, Date time){
        this.address = address;
        this.time = time;
    }

    public String getTime()
    {
        SimpleDateFormat sdfr = new SimpleDateFormat("HH:MM");
        String timeString = null;
        timeString = sdfr.format(time);
        return timeString;
    }

    public String getAddress() {
        return address;
    }
}
