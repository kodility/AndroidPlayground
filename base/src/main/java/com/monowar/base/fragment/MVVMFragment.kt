package com.monowar.base.fragment

import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class MVVMFragment : BaseFragment() {
    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
}