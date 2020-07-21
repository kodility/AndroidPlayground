package com.androidplayground.coreandroid.fragment

import android.content.Context
import android.content.Intent
import androidx.annotation.AnimRes
import androidx.fragment.app.Fragment
import com.androidplayground.coreandroid.R
import kotlin.reflect.KClass

abstract class BaseFragment : Fragment() {

    lateinit var baseCommunicator: BaseFragmentCommunicator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseFragmentCommunicator) {
            baseCommunicator = context
        } else {
            throw ClassCastException("$context must implement BaseFragmentCommunicator")
        }
    }

    fun startActivity(
        intent: Intent,
        finishActivity: Boolean,
        @AnimRes enterAnim: Int = R.anim.slide_in_right,
        @AnimRes exitAnim: Int = R.anim.slide_out_left
    ) {
        startActivity(intent)
        baseCommunicator.animateStartActivity(enterAnim, exitAnim)
        if (finishActivity) {
            activity?.finish()
        }
    }

    fun startActivity(
        activityClass: KClass<*>,
        finishActivity: Boolean = false,
        @AnimRes enterAnim: Int = R.anim.slide_in_right,
        @AnimRes exitAnim: Int = R.anim.slide_out_left
    ) {
        startActivity(Intent(context, activityClass.java), finishActivity, enterAnim, exitAnim)
    }

    fun clearAllAndStartActivity(
        activityClass: KClass<*>,
        @AnimRes enterAnim: Int = R.anim.slide_in_right,
        @AnimRes exitAnim: Int = R.anim.slide_out_left
    ) {
        val intent = Intent(context, activityClass.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        baseCommunicator.animateStartActivity(enterAnim, exitAnim)
    }

    fun getFragment(): Fragment = this
}
