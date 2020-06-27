package com.androidplayground.coreandroid.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.androidplayground.coreandroid.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Created by Mostafa Monowar at 16-Apr-20 3:37 AM
 * monowar1993@gmail.com
 */

fun getLoaderDialog(context: Context): AlertDialog {
    val builder = MaterialAlertDialogBuilder(context, R.style.LoaderDialog)

    @Suppress("InflateParams")
    val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_loader, null)

    builder.setView(dialogView)
    builder.setCancelable(false)

    return builder.create()
}
