package com.ayodele.bible.ui.bible

import com.ayodele.bible.base.MVPContract


interface BibleContract {
    interface View : MVPContract.View

    interface Presenter<V : View> : MVPContract.Presenter<V>

    interface Component<V : View, out P : Presenter<V>> : MVPContract.Component<V, P>
}