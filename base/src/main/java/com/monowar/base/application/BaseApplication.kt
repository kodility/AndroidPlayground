package com.monowar.base.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.monowar.base.lifecycleobserver.ApplicationObserver

abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val processLifecycle = ProcessLifecycleOwner.get().lifecycle
        processLifecycle.addObserver(ApplicationObserver())
    }
}