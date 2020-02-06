package com.monowar.base.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.monowar.base.lifecycleobserver.ApplicationObserver

abstract class BaseApplication : Application() {

    val processLifecycle by lazy { ProcessLifecycleOwner.get().lifecycle }

    override fun onCreate() {
        super.onCreate()

        processLifecycle.addObserver(ApplicationObserver())
    }
}