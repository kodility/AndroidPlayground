package com.monowar.base.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    lateinit var baseCommunicator: BaseFragmentCommunicator

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(getFragment())
        super.onAttach(context)
        if (context is BaseFragmentCommunicator) {
            baseCommunicator = context
        } else {
            throw ClassCastException("$context must implement BaseFragmentCommunicator")
        }
    }

    fun getFragment(): Fragment = this
}