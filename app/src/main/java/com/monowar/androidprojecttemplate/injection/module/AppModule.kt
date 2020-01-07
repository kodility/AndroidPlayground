package com.monowar.androidprojecttemplate.injection.module

import android.app.Application
import android.content.Context
import com.monowar.base.injection.qualifires.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}