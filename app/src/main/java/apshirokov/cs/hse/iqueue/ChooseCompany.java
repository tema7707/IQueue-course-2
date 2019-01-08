package apshirokov.cs.hse.iqueue;

import java.net.URL;

public class ChooseCompany {

    private String companyName1, companyName2;
    private URL logoURL1, logoURL2;

    public ChooseCompany(String companyName, URL logoURL){
        this.companyName1 = companyName;
        this.logoURL1 = logoURL;
        // empty
        this.companyName2 = "";
        this.logoURL2 = null;
    }

    public ChooseCompany(String companyName, URL logoURL, String companyName2, URL logoURL2){
        this.companyName1 = companyName;
        this.logoURL1 = logoURL;
        this.companyName2 = companyName2;
        this.logoURL2 = logoURL2;
    }

    public String getCompanyName1() {
        return companyName1;
    }

    public URL getLogoURL1() {
        return logoURL1;
    }

    public String getCompanyName2() {
        return companyName2;
    }

    public URL getLogoURL2() {
        return logoURL2;
    }
}
