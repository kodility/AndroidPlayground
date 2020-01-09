package com.monowar.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class MVVMDataBindingFragment<VM : ViewModel, Binding : ViewDataBinding>: MVVMFragment() {

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
        viewModel = initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        setInitialValues()
        return dataBinding.root
    }
}