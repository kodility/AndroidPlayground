package com.androidplayground.kinofilm.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.androidplayground.core.scheduler.SchedulerProvider
import com.androidplayground.coreandroid.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val application: Application,
    @ApplicationContext private val applicationContext: Context,
    private val schedulerProvider: SchedulerProvider,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel()
