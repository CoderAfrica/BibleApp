package com.ayodele.bible.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ayodele.bible.R
import com.ayodele.bible.model.realm.BibleVerses

import io.realm.RealmResults


class BibleAdapter(private val context: Context, private var bibleVerses: RealmResults<BibleVerses>?, private var scrollPosition: Int) : RecyclerView.Adapter<BibleAdapter.BibleViewHolder>() {

    fun setBibleVerses(bibleVerses: RealmResults<BibleVerses>, position: Int) {
        this.bibleVerses = bibleVerses
        this.scrollPosition = position
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BibleViewHolder {
        val layoutView = LayoutInflater.from(context).inflate(R.layout.item_bible_read, parent, false)
        return BibleViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: BibleViewHolder, position: Int) {
        val verses = bibleVerses!![position]
        holder.bibleReadTitle.text = verses?.verseid.toString() + " " + verses?.versetext
    }

    override fun getItemCount(): Int  = bibleVerses!!.size

    class BibleViewHolder(var mView: View) : RecyclerView.ViewHolder(mView) {
        var bibleReadTitle: TextView

        init {
            bibleReadTitle = mView.findViewById<View>(R.id.bible_read_id) as TextView
        }
    }

}
