package com.test.hakolightnovelclone.object;

public class Chapter {
    private String id, chapterName, tenLn, noiDung;

    public Chapter() {
    }

    public Chapter(String chapterName, String tenLn, String noiDung) {
        this.chapterName = chapterName;
        this.tenLn = tenLn;
        this.noiDung = noiDung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getTenLn() {
        return tenLn;
    }

    public void setTenLn(String tenLn) {
        this.tenLn = tenLn;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
