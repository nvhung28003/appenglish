package com.example.yuroko.appfood.entity;

public class English {
    private String firstAvatar;
    private String title;
    private String href;

    public English(String firstAvatar, String title, String href) {
        this.firstAvatar = firstAvatar;
        this.title = title;
        this.href = href;
    }

    public English() {
    }

    public String getFirstAvatar() {
        return firstAvatar;
    }

    public void setFirstAvatar(String firstAvatar) {
        this.firstAvatar = firstAvatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
