package com.monowar.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class MVVMDataBindingFragment<DataBinding : ViewDataBinding>: MVVMFragment() {

    lateinit var viewModel: ViewModel

    lateinit var dataBinding: DataBinding

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutResourceId: Int

    /**
     * Override to create viewModel
     * @return view model instance
     */
    abstract fun initViewModel(): ViewModel

    /**
     * Override to set viewModel to dataBinding
     */
    abstract fun setViewModelInDataBinding(binding: DataBinding, viewModel: ViewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        setViewModelInDataBinding(dataBinding, viewModel)
        return dataBinding.root
    }
}