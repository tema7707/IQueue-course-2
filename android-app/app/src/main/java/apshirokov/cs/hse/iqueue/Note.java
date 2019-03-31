package apshirokov.cs.hse.iqueue;

//import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    @SerializedName("companyName")
    private String companyName;
    @SerializedName("address")
    private String address;
    @SerializedName("recordingTime")
    private Date recordingTime;
    @SerializedName("logoURL")
    private String logoURL;

    public Note(String companyName, String address, Date recordingTime, String logoURL){
        this.companyName = companyName;
        this.address = address;
        this.recordingTime = recordingTime;
        this.logoURL = logoURL;
    }

    public boolean isActual() {
        return new Date().after(recordingTime);
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getRecordingTime() {
        return recordingTime.toString();
    }

    public String getLogoURL() {
        return logoURL;
    }

    public String getDay(){
        SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM");
        String dateString = null;
        dateString = sdfr.format(recordingTime);
        return dateString;
    }

    public String getTime(){
        SimpleDateFormat sdfr = new SimpleDateFormat("HH:MM");
        String dateString = null;
        dateString = sdfr.format(recordingTime);
        return dateString;
    }
}
