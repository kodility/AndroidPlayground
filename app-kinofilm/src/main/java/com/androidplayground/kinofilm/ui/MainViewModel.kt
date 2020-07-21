package com.androidplayground.kinofilm.ui

import android.app.Application
import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.androidplayground.core.scheduler.SchedulerProvider
import com.androidplayground.coreandroid.viewmodel.BaseViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

class MainViewModel @ViewModelInject constructor(
    private val application: Application,
    @ApplicationContext private val applicationContext: Context,
    private val schedulerProvider: SchedulerProvider,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel()
