package com.ayodele.bible


import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.ayodele.bible.di.component.AppComponent
import com.ayodele.bible.di.component.DaggerAppComponent
import com.ayodele.bible.di.modules.AppModule
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {

    companion object {
        @JvmStatic
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        //initialise realm database
        Realm.init(this)

        var builder = RealmConfiguration.Builder()
        if (BuildConfig.DEBUG) builder = builder.deleteRealmIfMigrationNeeded()
        val realmConfiguration = builder.build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
