package com.ayodele.bible.ui.main

import android.content.Context
import com.ayodele.bible.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import io.realm.Realm


@Module
class MainPresenterModule(private val context: Context) {

    @Provides
    @ActivityScope
    fun provideContext(): Context {
        return context
    }

}
