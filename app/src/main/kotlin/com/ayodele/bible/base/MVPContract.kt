package com.ayodele.bible.base

interface MVPContract {
  interface View {
  }

    interface Presenter<V : View> {
    fun getView(): V?
    fun attachView(view: V)
    fun detachView()
  }

  interface Component<V : View, out P : Presenter<V>> {
    fun presenter(): P
  }
}