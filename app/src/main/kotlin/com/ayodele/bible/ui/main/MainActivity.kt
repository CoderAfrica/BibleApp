package com.ayodele.bible.ui.main

import android.os.Bundle
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.ayodele.bible.App
import com.ayodele.bible.R
import com.ayodele.bible.base.MVPDaggerMenuActivity
import com.ayodele.bible.ui.bible.BibleFragment
import io.realm.Realm


class MainActivity : MVPDaggerMenuActivity<MainContract.View, MainPresenter, MainComponent>(), MainContract.View {

    @BindView(R.id.toolbar)  @JvmField var toolbar: Toolbar? = null

    var realm: Realm? = null

    override fun createComponent(): MainComponent = DaggerMainComponent.builder()
            .appComponent(App.component)
            .mainPresenterModule(MainPresenterModule(this))
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        realm = Realm.getDefaultInstance();

        setSupportActionBar(toolbar)

        showBibleFragment()

    }

    override fun showBibleFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout_id, BibleFragment())
                .commit()
    }

    override fun onDestroy() {
        realm?.close()
        super.onDestroy()
    }


}
