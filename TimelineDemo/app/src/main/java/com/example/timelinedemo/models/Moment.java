package com.example.timelinedemo.models;

import java.util.ArrayList;
import java.util.List;

public class Moment {
    private String date;
    private String description;
    private String mediaUrl;
    private User user;
    private String location;

    public Moment(String date, String description, String mediaUrl, User user, String location) {
        this.date = date;
        this.description = description;
        this.mediaUrl = mediaUrl;
        this.user = user;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public User getUser() {
        return user;
    }

    public String getLocation() {
        return location;
    }

    public static List<Moment> generateTestData() {
        String tempImageUrl = "http://i.huffpost.com/gen/2598036/images/o-SAN-FRANCISCO-facebook.jpg";
        User user = new User("CodePath Demo", "https://pbs.twimg.com/profile_images/845611144987467776/3_cluFbs_400x400.jpg");

        List<Moment> momentList = new ArrayList<>();
        for (int i = 10; i <= 20; i++) {
            Moment moment = new Moment("MAR " + i, "Moment " + i + " : testing", tempImageUrl, user, "San Francisco, CA");
            momentList.add(moment);
        }

        return momentList;
    }
}
