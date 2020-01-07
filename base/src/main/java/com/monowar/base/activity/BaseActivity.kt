package com.monowar.base.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.AnimRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.monowar.base.utils.ConnectionLiveData
import com.monowar.base.utils.toast
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), BaseFragmentCommunicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(getActivity())
        super.onCreate(savedInstanceState)
        ConnectionLiveData(getContext()).observe(getActivity(), Observer { Log.d(TAG, "Network Connected: $it") })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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

    override fun startActivity(cls: Class<*>, finishSelf: Boolean, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        startActivity(Intent(getContext(), cls), finishSelf, enterAnim, exitAnim)
    }

    override fun clearAllAndStartActivity(cls: Class<*>, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
        val intent = Intent(getContext(), cls)
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

    companion object {
        private const val TAG = "BaseActivity"
    }
}