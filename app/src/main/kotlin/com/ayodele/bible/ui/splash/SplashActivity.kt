package com.ayodele.bible.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ayodele.bible.R
import com.ayodele.bible.service.DataLoaderService
import com.ayodele.bible.ui.main.MainActivity
import com.ayodele.bible.util.dataloader.BibleDataLoader
import io.realm.Realm

class SplashActivity : AppCompatActivity() {

    private var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        realm = Realm.getDefaultInstance()
        if (!BibleDataLoader.isBiblePreloaded(realm!!)) {
            DataLoaderService.startLoadingBibleData(this)
        }

        startActivity(Intent(this@SplashActivity, MainActivity::class.java))

    }

    override fun onDestroy() {
        realm?.close()
        super.onDestroy()
    }
}
