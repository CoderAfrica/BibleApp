package com.ayodele.bible.service

import android.app.IntentService
import android.content.Context
import android.content.Intent

import com.ayodele.bible.util.dataloader.BibleDataLoader

import io.realm.Realm

class DataLoaderService : IntentService("DataLoaderService") {

    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val action = intent.action
            if ("bible" == action) {
                loadBibleData()
            }
        }
    }

    private fun loadBibleData() {
        val realm = Realm.getDefaultInstance()
        BibleDataLoader.preloadedBible(realm, this)
        realm.close()
    }

    companion object {

        fun startLoadingBibleData(context: Context) {
            val intent = Intent(context, DataLoaderService::class.java)
            intent.action = "bible"
            context.startService(intent)
        }
    }


}
