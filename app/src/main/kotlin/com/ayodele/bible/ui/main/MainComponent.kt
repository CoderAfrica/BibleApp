package com.ayodele.bible.ui.main

import com.ayodele.bible.di.component.AppComponent
import com.ayodele.bible.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules= arrayOf(MainPresenterModule::class) )
interface MainComponent : MainContract.Component<MainContract.View,MainPresenter> {
  override fun presenter(): MainPresenter
}