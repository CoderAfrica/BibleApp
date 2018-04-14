package com.ayodele.bible.ui.bible

import android.content.Context
import com.ayodele.bible.base.MVPPresenter

class BiblePresenter
@javax.inject.Inject
constructor(val context: Context)
    : MVPPresenter<BibleContract.View>(), BibleContract.Presenter<BibleContract.View>