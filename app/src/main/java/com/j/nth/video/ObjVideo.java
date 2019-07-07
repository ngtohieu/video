package com.j.nth.video;

import android.graphics.Bitmap;

public class ObjVideo {
    String path;
    Bitmap image;
    String nameVideo;

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public ObjVideo(String path, Bitmap image, String nameVideo) {
        this.path = path;
        this.image = image;
        this.nameVideo = nameVideo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
