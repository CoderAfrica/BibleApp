package com.ayodele.bible.ui.bible

import com.ayodele.bible.base.MVPContract
import com.ayodele.bible.model.realm.BibleBooks
import com.ayodele.bible.model.realm.BibleChapter
import com.ayodele.bible.model.realm.BibleVerses
import io.realm.RealmResults


interface BibleContract {
    interface View : MVPContract.View

    interface Presenter<V : View> : MVPContract.Presenter<V> {
        val bibleBooks: RealmResults<BibleBooks>
        fun getBibleChaptersByBookId(bookId: Int?): RealmResults<BibleChapter>
        fun getBibleVerseByBookIdAndChapterId(bookId: Int, chapterId: Int): RealmResults<BibleVerses>
    }

    interface Component<V : View, out P : Presenter<V>> : MVPContract.Component<V, P>
}