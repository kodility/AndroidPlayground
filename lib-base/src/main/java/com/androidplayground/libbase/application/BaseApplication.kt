package com.androidplayground.libbase.application

import androidx.lifecycle.ProcessLifecycleOwner
import com.androidplayground.libbase.lifecycleobserver.ApplicationObserver
import dagger.android.support.DaggerApplication

abstract class BaseApplication : DaggerApplication() {

    val processLifecycle by lazy { ProcessLifecycleOwner.get().lifecycle }

    override fun onCreate() {
        super.onCreate()

        processLifecycle.addObserver(ApplicationObserver())
    }
}
