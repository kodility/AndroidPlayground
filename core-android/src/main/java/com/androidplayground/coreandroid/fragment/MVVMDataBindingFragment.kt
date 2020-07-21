package com.androidplayground.coreandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class MVVMDataBindingFragment<DataBinding : ViewDataBinding> : BaseFragment() {

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        setInitialValues()
        return dataBinding.root
    }
}
