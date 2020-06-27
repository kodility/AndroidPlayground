package com.androidplayground.coreandroid.application

import androidx.lifecycle.ProcessLifecycleOwner
import com.androidplayground.coreandroid.lifecycleobserver.ApplicationObserver
import dagger.android.support.DaggerApplication

abstract class BaseApplication : DaggerApplication() {

    val processLifecycle by lazy { ProcessLifecycleOwner.get().lifecycle }

    override fun onCreate() {
        super.onCreate()

        processLifecycle.addObserver(ApplicationObserver())
    }
}
