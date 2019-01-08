package apshirokov.cs.hse.iqueue;

import java.net.URL;
import java.util.Date;

public class Note {

    private String companyName;
    private String address;
    private Date recordingTime;
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
}
