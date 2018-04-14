package com.ayodele.bible.ui.bible

import android.content.Context
import com.ayodele.bible.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class BiblePresenterModule(private val context: Context, private val realm : Realm) {

    @Provides
    @ActivityScope
    fun provideContext(): Context = context

    @Provides
    fun provideRealm(): Realm  = realm
}
