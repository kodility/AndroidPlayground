package com.monowar.androidprojecttemplate.injection

import android.app.Application
import com.monowar.androidprojecttemplate.App
import com.monowar.androidprojecttemplate.injection.module.ActivityModule
import com.monowar.androidprojecttemplate.injection.module.AppModule
import com.monowar.androidprojecttemplate.injection.module.ViewModelModule
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

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}