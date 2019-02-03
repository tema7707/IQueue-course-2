package apshirokov.cs.hse.iqueue;

//import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
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

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public void setAddress(String address) { this.address = address; }

    public void setLogoURL(String logoURL) { this.logoURL = logoURL; }

    public void setRecordingTime(Date recordingTime) { this.recordingTime = recordingTime; }
}
