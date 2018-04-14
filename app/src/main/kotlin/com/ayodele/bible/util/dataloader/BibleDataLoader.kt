package com.ayodele.bible.util.dataloader

import android.content.Context

import com.ayodele.bible.model.realm.BibleBooks
import com.ayodele.bible.model.realm.BibleChapter
import com.ayodele.bible.model.realm.BibleVerses

import java.io.IOException
import java.io.InputStream

import io.realm.Realm
import io.realm.RealmObject

object BibleDataLoader {

    fun preloadedBible(realm: Realm, context: Context) {
        loadJsonAllFromAssets(realm, context, BibleBooks::class.java, "biblebook.json")
        loadJsonAllFromAssets(realm, context, BibleChapter::class.java, "biblechapter.json")
        loadJsonAllFromAssets(realm, context, BibleVerses::class.java, "bibleverses.json")
    }

    fun <T : RealmObject> loadJsonAllFromAssets(realm: Realm, context: Context, clazz: Class<T>, fileNameInAsset: String) {
        val results = realm.where(clazz).findAll()

        if (results.isEmpty()) {
            var stream: InputStream? = null
            try {
                stream = context.assets.open(fileNameInAsset)
                if (stream != null) {
                    realm.beginTransaction()
                    realm.createAllFromJson(clazz, stream)
                    realm.commitTransaction()
                }
            } catch (e: IOException) {
                // Remember to cancel the transaction if anything goes wrong.
                if (realm.isInTransaction)
                    realm.cancelTransaction()
            } finally {
                if (stream != null) {
                    try {
                        stream.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }
        }
    }

    fun isBiblePreloaded(realm: Realm): Boolean {
        return realm.where(BibleBooks::class.java).count() > 0
    }
}
