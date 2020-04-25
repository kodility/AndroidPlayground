package com.androidplayground.libcommon.injection

import com.androidplayground.libcommon.scheduler.AndroidSchedulerProvider
import com.androidplayground.libcommon.scheduler.SchedulerProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Mostafa Monowar at 25-Apr-20 2:19 AM
 * monowar1993@gmail.com
 */
@Module
abstract class SchedulersModule {
    @Binds
    abstract fun bindSchedulerProvider(androidSchedulerProvider: AndroidSchedulerProvider): SchedulerProvider
}
