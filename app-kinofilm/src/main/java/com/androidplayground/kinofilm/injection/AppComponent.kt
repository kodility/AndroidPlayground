package com.androidplayground.kinofilm.injection

import android.app.Application
import com.androidplayground.kinofilm.App
import com.androidplayground.kinofilm.injection.module.ActivityModule
import com.androidplayground.kinofilm.injection.module.AppModule
import com.androidplayground.kinofilm.injection.module.ViewModelModule
import com.androidplayground.libcommon.injection.SchedulersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        SchedulersModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }
}
