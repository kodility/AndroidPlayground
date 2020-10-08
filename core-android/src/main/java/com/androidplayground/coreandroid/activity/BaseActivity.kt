package com.androidplayground.coreandroid.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.AnimRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.androidplayground.coreandroid.fragment.BaseFragmentCommunicator
import com.androidplayground.coreandroid.utils.ConnectionLiveData
import com.androidplayground.coreandroid.utils.toast
import kotlin.reflect.KClass
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity(), BaseFragmentCommunicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ConnectionLiveData(getContext()).observe(getActivity(), Observer { Timber.d("Network Connected: $it") })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun getContext(): Context = this

    fun getActivity(): AppCompatActivity = this

    override fun showSoftKeyboard(editText: EditText) {
        editText.requestFocus()
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }

    override fun hideSoftKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun startActivity(intent: Intent, finishSelf: Boolean, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        startActivity(intent)
        animateStartActivity(enterAnim, exitAnim)
        if (finishSelf) {
            finish()
        }
    }

    override fun startActivity(activityClass: KClass<*>, finishSelf: Boolean, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        startActivity(Intent(getContext(), activityClass.java), finishSelf, enterAnim, exitAnim)
    }

    override fun clearAllAndStartActivity(activityClass: KClass<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        val intent = Intent(getContext(), activityClass.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        animateStartActivity(enterAnim, exitAnim)
    }

    override fun animateStartActivity(enterAnim: Int, exitAnim: Int) {
        overridePendingTransition(enterAnim, exitAnim)
    }

    override fun animateEndActivity(enterAnim: Int, exitAnim: Int) {
        overridePendingTransition(enterAnim, exitAnim)
    }

    override fun showToast(message: String?) {
        message?.let { runOnUiThread { toast(it) } }
    }
}
