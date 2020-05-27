package com.androidplayground.coreandroid.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class MVVMDataBindingActivity<VM : ViewModel, DataBinding : ViewDataBinding> : MVVMActivity<VM>() {

    lateinit var dataBinding: DataBinding

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutResourceId: Int

    /**
     * Override to set initial values in viewModel and dataBinding
     */
    abstract fun setInitialValues()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(getActivity(), layoutResourceId)
        dataBinding.lifecycleOwner = getActivity()
        setInitialValues()
    }
}
