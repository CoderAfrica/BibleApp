package com.ayodele.bible.ui.bible

import android.content.Context
import com.ayodele.bible.base.MVPPresenter
import com.ayodele.bible.model.realm.BibleBooks
import com.ayodele.bible.model.realm.BibleChapter
import com.ayodele.bible.model.realm.BibleVerses
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort

class BiblePresenter @javax.inject.Inject constructor(var context: Context, var realm: Realm)
    : MVPPresenter<BibleContract.View>(), BibleContract.Presenter<BibleContract.View> {

    override fun getBibleVerseByBookIdAndChapterId(bookId: Int, chapterId: Int): RealmResults<BibleVerses> = realm.where(BibleVerses::class.java)
            .equalTo("bookid", bookId)
            .equalTo("chapterid", chapterId)
            .sort("verseid", Sort.ASCENDING)
            .findAll()

    override fun getBibleChaptersByBookId(bookId: Int?): RealmResults<BibleChapter> = realm.where(BibleChapter::class.java)
            .equalTo("bookid", bookId)
            .sort("chapterid", Sort.ASCENDING)
            .findAll()


    override val bibleBooks: RealmResults<BibleBooks>
        get() = realm.where(BibleBooks::class.java).findAll()
}