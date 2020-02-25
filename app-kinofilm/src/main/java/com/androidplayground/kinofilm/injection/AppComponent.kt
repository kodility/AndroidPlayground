package com.androidplayground.kinofilm.injection

import android.app.Application
import com.androidplayground.kinofilm.App
import com.androidplayground.kinofilm.injection.module.ActivityModule
import com.androidplayground.kinofilm.injection.module.AppModule
import com.androidplayground.kinofilm.injection.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    /*@Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }*/
    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }
}
