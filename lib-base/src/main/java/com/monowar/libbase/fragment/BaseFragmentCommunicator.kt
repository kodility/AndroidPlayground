package com.monowar.libbase.fragment

import android.content.Intent
import android.view.View
import android.widget.EditText
import androidx.annotation.AnimRes
import com.monowar.libbase.R

interface BaseFragmentCommunicator {
    fun showSoftKeyboard(editText: EditText)
    fun hideSoftKeyboard(view: View)
    fun startActivity(
        intent: Intent,
        finishSelf: Boolean = false, @AnimRes enterAnim: Int = R.anim.slide_in_right, @AnimRes exitAnim: Int = R.anim.slide_out_left
    )
    fun startActivity(
        cls: Class<*>,
        finishSelf: Boolean = false, @AnimRes enterAnim: Int = R.anim.slide_in_right, @AnimRes exitAnim: Int = R.anim.slide_out_left
    )
    fun clearAllAndStartActivity(cls: Class<*>, @AnimRes enterAnim: Int = R.anim.slide_in_right, @AnimRes exitAnim: Int = R.anim.slide_out_left)
    fun animateStartActivity(@AnimRes enterAnim: Int = R.anim.slide_in_right, @AnimRes exitAnim: Int = R.anim.slide_out_left)
    fun animateEndActivity(@AnimRes enterAnim: Int = R.anim.slide_in_left, @AnimRes exitAnim: Int = R.anim.slide_out_right)
    fun showToast(message: String?)
}