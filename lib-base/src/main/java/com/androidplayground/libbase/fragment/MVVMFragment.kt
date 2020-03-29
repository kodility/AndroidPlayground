package com.androidplayground.libbase.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class MVVMFragment<VM : ViewModel> : BaseFragment() {

    @Inject
    lateinit var vmFactory: dagger.Lazy<ViewModelProvider.Factory>

    /**
     * Index of 0 means first argument of Base class param.
     *
     * @return View Model class type. Need to create an instance of the view model.
     */
    @Suppress("UNCHECKED_CAST")
    private val vmClass: Class<VM> = ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]) as Class<VM>

    val viewModel by lazy { ViewModelProvider(getFragment(), vmFactory.get()).get(vmClass) }
}
