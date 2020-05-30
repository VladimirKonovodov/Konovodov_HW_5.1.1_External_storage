package com.example.konovodov_hw_511_external_storage;

import android.graphics.drawable.Drawable;

public class ItemData {

    private Drawable image;
    private String title;
    private String subtitleCategory;

    private String subtitle;


    public ItemData(Drawable image, String title, String subtitleCategory, String subtitle) {
        this.image = image;
        this.title = title;
        this.subtitleCategory = subtitleCategory;
        this.subtitle = subtitle;

    }
    public ItemData(String title, String subtitleCategory, String subtitle) {
        this.title = title;
        this.subtitleCategory = subtitleCategory;
        this.subtitle = subtitle;

    }

    public Drawable getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getSubtitleCategory() {
        return subtitleCategory;
    }


}