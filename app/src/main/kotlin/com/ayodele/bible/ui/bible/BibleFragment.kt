package com.ayodele.bible.ui.bible


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import butterknife.BindView
import butterknife.ButterKnife
import com.ayodele.bible.App
import com.ayodele.bible.R
import com.ayodele.bible.base.MVPDaggerFragment
import com.ayodele.bible.model.realm.BibleBooks
import com.ayodele.bible.model.realm.BibleChapter
import com.ayodele.bible.model.realm.BibleVerses
import com.ayodele.bible.ui.adapters.BibleAdapter
import com.ayodele.bible.ui.main.MainActivity
import io.realm.RealmResults


@Suppress("UNUSED_EXPRESSION")
class BibleFragment : MVPDaggerFragment<BibleContract.View, BiblePresenter, BibleComponent>(), BibleContract.View {

    override fun createComponent(): BibleComponent = DaggerBibleComponent.builder()
            .appComponent(App.component)
            .biblePresenterModule(BiblePresenterModule(activity!!, (activity as MainActivity).realm))
            .build()


    @BindView(R.id.bible_book_spinner)
    @JvmField
    var bibleBooksSpinner: Spinner? = null

    @BindView(R.id.chapter_spinner)
    @JvmField
    var chapterSpinner: Spinner? = null

    @BindView(R.id.verse_spinner)
    @JvmField
    var verseSpinner: Spinner? = null

    @BindView(R.id.read_bible_recyclerview)
    @JvmField
    var readBibleRecyclerView: RecyclerView? = null

    private lateinit var bibleReadAdapter: BibleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater!!.inflate(R.layout.fragment_bible_read, container, false)
        ButterKnife.bind(this, layout)

        val bibleBooks = presenter.bibleBooks

        val adapter = ArrayAdapter<BibleBooks>(activity, android.R.layout.simple_spinner_item, bibleBooks)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bibleBooksSpinner?.adapter = adapter

        bibleBooksSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                if (position >= 0) {
                    val bookId = bibleBooks[position]?.bookid
                    val chaptersInBook = presenter.getBibleChaptersByBookId(bookId)
                    getChapterByBook(bookId, chaptersInBook)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }

        bibleBooksSpinner!!.setSelection(0)

        readBibleRecyclerView!!.layoutManager = LinearLayoutManager(activity)

        //firstload
        showInitialView(1,1)

        return layout
    }

    override fun showInitialView(bookId : Int, chapterId: Int) {
        val result = presenter.getBibleVerseByBookIdAndChapterId(bookId, chapterId)
        bibleReadAdapter = BibleAdapter(activity as MainActivity, result, 1)
        readBibleRecyclerView!!.adapter = bibleReadAdapter
    }

    override fun getChapterByBook(bookId: Int?, chaptersInBook: RealmResults<BibleChapter>) {

        val adapter = ArrayAdapter<BibleChapter>(activity, android.R.layout.simple_spinner_item, chaptersInBook)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        chapterSpinner!!.adapter = adapter

        chapterSpinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                if (position >= 0) {
                    val chapterId = chaptersInBook[position]?.chapterid
                    val result = displayVerseAndRespondToClicks(bookId, chapterId, 1) //Start from the first verse
                    getVersesByChapter(bookId, chapterId, result)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }
        chapterSpinner!!.setSelection(0)
    }

    override fun getVersesByChapter(bookId: Int?, chapterId: Int?, versesInChapter : RealmResults<BibleVerses>) {

        val adapter = ArrayAdapter<BibleVerses>(activity, android.R.layout.simple_spinner_item, versesInChapter)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        verseSpinner!!.adapter = adapter

        verseSpinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                if (position >= 0) {
                    displayVerseAndRespondToClicks(bookId, chapterId, versesInChapter[position]?.verseid)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }
    }

    private fun displayVerseAndRespondToClicks(bookId: Int?, chapterId: Int?, verseId: Int?): RealmResults<BibleVerses> {
        val result = presenter.getBibleVerseByBookIdAndChapterId(bookId!!,chapterId!!)
        bibleReadAdapter.setBibleVerses(result, verseId!!)
        readBibleRecyclerView!!.scrollToPosition(verseId)
        return result
    }


}// Required empty public constructor
