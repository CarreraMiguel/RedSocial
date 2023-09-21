package com.campusdual.SocialMedia;

import com.campusdual.Utils;

import java.util.Date;

public class PostVideo extends Post{
    protected int quality;
    protected int duration;

    public PostVideo() {
        super();
        this.quality = Utils.integer("Calidad del video: ");
        this.duration = Utils.integer("Duracion: ");
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return "Estos son tus post de video --> " +
                "Título del video: " + postTitle + '\'' +
                " Fecha: " + postDate +
                " Calidad: " + quality +
                " Duración: " + duration;
    }
}
