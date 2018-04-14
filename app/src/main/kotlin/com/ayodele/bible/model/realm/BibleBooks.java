package com.ayodele.bible.model.realm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class BibleBooks extends RealmObject {

    @SerializedName("abbrev")
    @Expose
    private String abbrev;
    @SerializedName("bookname")
    @Expose
    private String bookname;
    @SerializedName("noOfChapter")
    @Expose
    private Integer noOfChapter;
    @SerializedName("bookid")
    @Expose
    private Integer bookid;

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getNoOfChapter() {
        return noOfChapter;
    }

    public void setNoOfChapter(Integer noOfChapter) {
        this.noOfChapter = noOfChapter;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return bookname;
    }
}
