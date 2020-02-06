package com.monowar.androidplayground

import com.jakewharton.threetenabp.AndroidThreeTen
import com.monowar.androidplayground.injection.DaggerAppComponent
import com.monowar.libbase.application.BaseApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : BaseApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        /*DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)*/
        DaggerAppComponent.factory().create(this).inject(this)

        AndroidThreeTen.init(this)
    }
}