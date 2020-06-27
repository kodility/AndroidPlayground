package com.androidplayground.kinofilm.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidplayground.coreandroid.injection.ViewModelKey
import com.androidplayground.coreandroid.viewmodel.ViewModelFactory
import com.androidplayground.kinofilm.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * All ViewModel classes that uses Dagger2 injection, must be declared here to support constructor injection,
 * otherwise app will give following exception on runtime access:
 * IllegalArgumentException: "unknown model call class"
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
