package com.ayodele.bible.di.modules

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

@Module
class AppModule(internal var mApplication: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application = mApplication

    @Provides
    @Singleton
    fun provideGson(): Gson  = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .create()

}
