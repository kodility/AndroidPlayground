package com.androidplayground.libcommon.scheduler

import io.reactivex.rxjava3.core.Scheduler

/**
 * Created by Mostafa Monowar at 25-Apr-20 2:08 AM
 * monowar1993@gmail.com
 *
 * Allows providing different types of [Scheduler]s.
 */
interface SchedulerProvider {
    fun trampoline(): Scheduler

    fun newThread(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler

    fun main(): Scheduler
}
