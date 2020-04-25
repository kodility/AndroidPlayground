package com.androidplayground.libcommon.scheduler

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mostafa Monowar at 25-Apr-20 2:08 AM
 * monowar1993@gmail.com
 *
 * Provides different types of [Scheduler]s specific to Android framework.
 */
@Singleton
class AndroidSchedulerProvider @Inject constructor() : SchedulerProvider {
    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun main(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
