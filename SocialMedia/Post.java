package com.campusdual.SocialMedia;

import com.campusdual.Utils;

import java.util.*;

public abstract class Post {

    protected String postTitle;
    protected Date postDate;
    protected List<Comentaries> postComentaries = new ArrayList<>();

    public Post() {
        this.postTitle = Utils.string("Titulo: ");
        this.postDate = new Date();
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

}

