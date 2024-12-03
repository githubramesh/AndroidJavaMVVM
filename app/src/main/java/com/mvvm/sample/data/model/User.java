package com.mvvm.sample.data.model;

public class User {
    private String name;
    private String jobTitle;
    private String email;
    private String imageURL;
    private String jobLocation;

    public User(String name, String jobTitle, String email, String imageURL, String jobLocation) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.imageURL = imageURL;
        this.jobLocation = jobLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }
}
