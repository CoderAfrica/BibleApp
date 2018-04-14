package com.ayodele.bible.ui.main

import com.ayodele.bible.base.MVPContract

interface MainContract {
    interface View : MVPContract.View {
        fun showBibleFragment()
    }

    interface Presenter<V : View> : MVPContract.Presenter<V> {

    }

    interface Component<V : View, out P : Presenter<V>> : MVPContract.Component<V, P>
}