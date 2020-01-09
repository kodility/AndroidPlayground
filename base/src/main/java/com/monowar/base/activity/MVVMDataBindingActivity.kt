package com.monowar.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class MVVMDataBindingActivity<VM : ViewModel, Binding : ViewDataBinding> : MVVMActivity() {

    lateinit var viewModel: VM

    lateinit var dataBinding: Binding

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutResourceId: Int

    /**
     * Override to create viewModel
     * @return view model instance
     */
    abstract fun initViewModel(): VM

    /**
     * Override to set initial values in viewModel and dataBinding
     */
    abstract fun setInitialValues()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(getActivity(), layoutResourceId)
        dataBinding.lifecycleOwner = getActivity()
        viewModel = initViewModel()
        setInitialValues()
    }
}