package com.ayodele.bible.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ayodele.bible.R

abstract class MVPDaggerMenuActivity<V : MVPContract.View, out P : MVPContract.Presenter<V>,
        out C : MVPContract.Component<V, P>> : AppCompatActivity(), MVPContract.View {

    protected val presenter: P by lazy { component.presenter() }
    protected val component: C by lazy { createComponent() }

    protected abstract fun createComponent(): C

    //This happens under the hood in java.
    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
