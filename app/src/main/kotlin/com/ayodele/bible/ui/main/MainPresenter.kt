package com.ayodele.bible.ui.main

import android.content.Context
import com.ayodele.bible.base.MVPPresenter
import javax.inject.Inject

class MainPresenter
@Inject
constructor(val context: Context) : MVPPresenter<MainContract.View>(), MainContract.Presenter<MainContract.View> {

}