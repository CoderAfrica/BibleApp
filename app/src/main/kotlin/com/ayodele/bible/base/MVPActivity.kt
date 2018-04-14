package com.ayodele.bible.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MVPActivity<V : MVPContract.View, out P : MVPContract.Presenter<V>>
    : AppCompatActivity(), MVPContract.View {

    protected val presenter: P by lazy { createPresenter() }
    protected abstract fun createPresenter(): P

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}