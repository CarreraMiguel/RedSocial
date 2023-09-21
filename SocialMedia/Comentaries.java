package com.campusdual.SocialMedia;

import java.util.Date;

public class Comentaries {
    protected String text;
    protected Date comentaryDate;
    protected User property;

    public Comentaries(String text, Date comentaryDate, User property) {
        this.text = text;
        this.comentaryDate = comentaryDate;
        this.property = property;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getComentaryDate() {
        return comentaryDate;
    }

    public void setComentaryDate(Date comentaryDate) {
        this.comentaryDate = comentaryDate;
    }

    public User getProperty() {
        return property;
    }

    public void setProperty(User property) {
        this.property = property;
    }

}
