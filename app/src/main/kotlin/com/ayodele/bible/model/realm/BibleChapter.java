package com.ayodele.bible.model.realm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class BibleChapter extends RealmObject {

    @SerializedName("chapterid")
    @Expose
    private Integer chapterid;
    @SerializedName("bookid")
    @Expose
    private Integer bookid;
    @SerializedName("noOfVerses")
    @Expose
    private Integer noOfVerses;

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

    public Integer getNoOfVerses() {
        return noOfVerses;
    }

    public void setNoOfVerses(Integer noOfVerses) {
        this.noOfVerses = noOfVerses;
    }

    @Override
    public String toString() {
        return String.valueOf(chapterid);
    }
}
