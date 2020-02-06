package com.monowar.androidplayground.injection

import android.app.Application
import com.monowar.androidplayground.App
import com.monowar.androidplayground.injection.module.ActivityModule
import com.monowar.androidplayground.injection.module.AppModule
import com.monowar.androidplayground.injection.module.ViewModelModule
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