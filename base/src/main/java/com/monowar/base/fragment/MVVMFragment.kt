package com.monowar.base.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

abstract class MVVMFragment<VM : ViewModel> : BaseFragment() {

    @Inject
    lateinit var vmFactory: dagger.Lazy<ViewModelProvider.Factory>

    /**
     * @return View Model class type. Need to create an instance of the view model.
     */
    abstract val viewModelClass: Class<VM>

    val viewModel by lazy { ViewModelProviders.of(getFragment(), vmFactory.get()).get(viewModelClass) }
}