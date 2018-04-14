package com.ayodele.bible.ui.bible

import android.content.Context
import com.ayodele.bible.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class BiblePresenterModule(private val context: Context) {

    @Provides
    @ActivityScope
    fun provideContext(): Context {
        return context
    }
}
