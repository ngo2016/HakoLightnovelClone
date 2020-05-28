package com.test.hakolightnovelclone.object;

import java.io.Serializable;

public class Lightnovel implements Serializable {
    String tenLn, imgLink;
    int id;

    public Lightnovel() {
    }

    public Lightnovel(String tenLn, String imgLink) {
        this.tenLn = tenLn;
        this.imgLink = imgLink;
    }

    public String getTenLn() {
        return tenLn;
    }

    public void setTenLn(String tenLn) {
        this.tenLn = tenLn;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
