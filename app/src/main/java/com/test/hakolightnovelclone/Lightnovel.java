package com.test.hakolightnovelclone;

public class Lightnovel {
    String tenLn, imgLink;

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
}
