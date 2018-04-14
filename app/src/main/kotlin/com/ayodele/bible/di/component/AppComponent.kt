package com.ayodele.bible.di.component

import com.ayodele.bible.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent
