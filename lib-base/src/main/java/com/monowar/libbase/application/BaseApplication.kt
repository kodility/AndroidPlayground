package com.monowar.libbase.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.monowar.libbase.lifecycleobserver.ApplicationObserver

abstract class BaseApplication : Application() {

    val processLifecycle by lazy { ProcessLifecycleOwner.get().lifecycle }

    override fun onCreate() {
        super.onCreate()

        processLifecycle.addObserver(ApplicationObserver())
    }
}