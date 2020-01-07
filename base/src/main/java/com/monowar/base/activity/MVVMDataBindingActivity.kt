package com.monowar.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class MVVMDataBindingActivity<DataBinding : ViewDataBinding> : MVVMActivity() {

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
        dataBinding = DataBindingUtil.setContentView(getActivity(), layoutResourceId)
        dataBinding.lifecycleOwner = getActivity()
        viewModel = initViewModel()
        setViewModelInDataBinding(dataBinding, viewModel)
    }
}