package com.androidplayground.libbase.lifecycleobserver

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ApplicationObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Log.d(TAG, "App in foreground")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Log.d(TAG, "App in background")
    }

    companion object {
        private const val TAG = "ApplicationObserver"
    }
}
