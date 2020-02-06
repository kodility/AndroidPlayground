package com.monowar.libbase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {

    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun Disposable.autoDispose() = apply { compositeDisposable.add(this) }
}