package com.ayodele.bible.ui.bible

import com.ayodele.bible.di.component.AppComponent
import com.ayodele.bible.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(BiblePresenterModule::class))
interface BibleComponent : BibleContract.Component<BibleContract.View, BiblePresenter> {
  override fun presenter(): BiblePresenter
}