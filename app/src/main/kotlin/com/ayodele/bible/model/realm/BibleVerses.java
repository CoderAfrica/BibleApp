
package com.ayodele.bible.model.realm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class BibleVerses extends RealmObject{

    @SerializedName("chapterid")
    @Expose
    private Integer chapterid;
    @SerializedName("bookid")
    @Expose
    private Integer bookid;
    @SerializedName("verseid")
    @Expose
    private Integer verseid;

    @SerializedName("versetext")
    @Expose
    private String versetext;

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getVerseid() {
        return verseid;
    }

    public void setVerseid(Integer verseid) {
        this.verseid = verseid;
    }

    public String getVersetext() {
        return versetext;
    }

    public void setVersetext(String versetext) {
        this.versetext = versetext;
    }

    @Override
    public String toString() {
        return String.valueOf(verseid);
    }
}
