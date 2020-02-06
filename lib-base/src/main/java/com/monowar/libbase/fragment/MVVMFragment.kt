package com.monowar.libbase.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class MVVMFragment<VM : ViewModel> : BaseFragment() {

    @Inject
    lateinit var vmFactory: dagger.Lazy<ViewModelProvider.Factory>

    /**
     * @return View Model class type. Need to create an instance of the view model.
     */
    abstract val viewModelClass: Class<VM>

    val viewModel by lazy { ViewModelProvider(getFragment(), vmFactory.get()).get(viewModelClass) }
}