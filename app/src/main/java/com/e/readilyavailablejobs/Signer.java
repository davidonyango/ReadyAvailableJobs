package com.e.readilyavailablejobs;

import com.google.firebase.database.IgnoreExtraProperties;

public class Signer {

    private String signerLastName;
    private String signerUserName;
    private String signerEmailAddress;
    private String signerPhoneNumber;
    private String signerPassword;
    private String signerConfirmPassword;


// Empty consructor is needed to be set up.


    public Signer() {

    }

    public Signer(String signerLastName, String signerUserName,
                  String signerEmailAddress, String signerPhoneNumber, String signerPassword, String signerConfirmPassword) {

        this.signerLastName = signerLastName;
        this.signerUserName = signerUserName;
        this.signerEmailAddress = signerEmailAddress;
        this.signerPhoneNumber = signerPhoneNumber;
        this.signerPassword = signerPassword;
        this.signerConfirmPassword = signerConfirmPassword;
    }

    // Setting up a Getter.
    public String getSignerLastName() {
        return signerLastName;
    }

    public String getSignerUserName() {
        return signerUserName;
    }

    public String getSignerEmailAddress() {
        return signerEmailAddress;
    }

    public String getSignerPhoneNumber() {
        return signerPhoneNumber;
    }

    public String getSignerPassword() {
        return signerPassword;
    }

    public String getSignerConfirmPassword() {
        return signerConfirmPassword;
    }


 // Setting up a setter.
    public void setSignerLastName(String signerLastName) {
        this.signerLastName = signerLastName;
    }

    public void setSignerUserName(String signerUserName) {
        this.signerUserName = signerUserName;
    }

    public void setSignerEmailAddress(String signerEmailAddress) {
        this.signerEmailAddress = signerEmailAddress;
    }

    public void setSignerPhoneNumber(String signerPhoneNumber) {
        this.signerPhoneNumber = signerPhoneNumber;
    }

    public void setSignerPassword(String signerPassword) {
        this.signerPassword = signerPassword;
    }

    public void setSignerConfirmPassword(String signerConfirmPassword) {
        this.signerConfirmPassword = signerConfirmPassword;
    }
}
