package com.monowar.base.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
inline fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(this, message, duration)
        .apply {
            show()
        }
}


inline fun Fragment.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) = requireActivity().toast(text, duration)