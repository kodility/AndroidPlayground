package com.androidplayground.kinofilm

import com.androidplayground.kinofilm.injection.DaggerAppComponent
import com.androidplayground.libbase.application.BaseApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication

class App : BaseApplication(), HasAndroidInjector {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
    }
}
