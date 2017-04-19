package com.iamindiary.bean;

import java.io.Serializable;

/**
 * Created by NSC on 4/16/2017.
 */

public class EventBean implements Serializable {


    String title;
    String date;
    String time;
    String image;

    public EventBean(String title, String date, String time, String image) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}