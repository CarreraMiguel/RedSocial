package com.campusdual.SocialMedia;

import com.campusdual.Utils;

import java.util.Date;

public class PostImage extends Post{

    protected String dimension;

    public PostImage() {
        super();
        this.dimension = Utils.string("Tamaño de la imagen: ");
    }
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String toString() {
        return "Estos son tus post de imagen --> " +
                "Título de la imagen: " + postTitle + '\'' +
                " Tamaño de la imagen: " + dimension + '\'' +
                " Fecha de la imagen: " + postDate;
    }
}