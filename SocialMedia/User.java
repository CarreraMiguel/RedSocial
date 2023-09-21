package com.campusdual.SocialMedia;

import com.campusdual.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    protected String name;
    protected List<User> friends = new ArrayList<>();

    protected List<Post> myownPost = new ArrayList<>();



    public User() {
    }



    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Post> getMyownPost() {
        return myownPost;
    }

    public void setMyownPost(List<Post> myownPost) {
        this.myownPost = myownPost;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void savePost (Post post){
        myownPost.add(post);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

