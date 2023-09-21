package com.campusdual.SocialMedia;

import com.campusdual.Utils;

import java.util.Date;

public class PostText extends Post {
    protected String postContent;

    public PostText() {
        super();
        this.postContent = Utils.string("Contenido: ");
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String toString() {
        return "Estos son tus post de texto --->  " +
                "Título: " + postTitle + '\'' +
                " Fecha: " + postDate + " Texto: " + postContent;
    }

}

