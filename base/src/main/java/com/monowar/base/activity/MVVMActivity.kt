package com.monowar.base.activity

import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class MVVMActivity : BaseActivity() {

    @Inject
    lateinit var vmFactory: dagger.Lazy<ViewModelProvider.Factory>
}