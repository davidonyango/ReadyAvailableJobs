package com.e.readilyavailablejobs;

public class Davido {

private String userName;
private String userCountry;
private String userLocation;
private String userPhoneNumber;
private String userJob;
private String userJobDuration;
private String userRequirements;




    /**
     * Generating the actual constructor
     */
    public Davido(String userName, String userCountry, String userLocation,
                  String userPhoneNumber, String userJob, String userJobDuration,
                  String userRequirements)
    {
        this.userName = userName;
        this.userCountry = userCountry;
        this.userLocation = userLocation;
        this.userPhoneNumber = userPhoneNumber;
        this.userJob = userJob;
        this.userJobDuration = userJobDuration;
        this.userRequirements = userRequirements;
    }

    /**
     * Generating an empty constructor
     * @param storeUserData
     * @param userName
     * @param userLocation
     * @param userPhoneNumber
     * @param userJob
     * @param userCountry
     * @param userJobDuration
     * @param userRequirements
     */
    public Davido(String storeUserData, String userName, String userLocation,
                  String userPhoneNumber, String userJob, String userCountry,
                  String userJobDuration, String userRequirements)
    {
        //Empty constructor needed
    }

    /**
     * Generating getters
     */
    public String getUserName() {
        return userName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserJob() {
        return userJob;
    }

    public String getUserJobDuration() {
        return userJobDuration;
    }

    public String getUserRequirements() {
        return userRequirements;
    }

    /**
     * Generating setters
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public void setUserJobDuration(String userJobDuration) {
        this.userJobDuration = userJobDuration;
    }

    public void setUserRequirements(String userRequirements) {
        this.userRequirements = userRequirements;
    }
}



