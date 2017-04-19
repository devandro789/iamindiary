package com.iamindiary.bean;

import java.io.Serializable;

/**
 * Created by NSC on 4/16/2017.
 */

public class PeopleBean implements Serializable {

    String name;
    String nickName;
    String image;
    String isFollowed;

    public PeopleBean(String name, String nickName, String image, String isFollowed) {
        this.name = name;
        this.nickName = nickName;
        this.image = image;
        this.isFollowed = isFollowed;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(String isFollowed) {
        this.isFollowed = isFollowed;
    }
}
