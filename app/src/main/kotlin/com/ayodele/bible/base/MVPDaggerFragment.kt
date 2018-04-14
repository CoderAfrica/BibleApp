package com.ayodele.bible.base

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class MVPDaggerFragment<V : MVPContract.View, out P : MVPContract.Presenter<V>,
        out C : MVPContract.Component<V, P>> : Fragment(), MVPContract.View {

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
}
