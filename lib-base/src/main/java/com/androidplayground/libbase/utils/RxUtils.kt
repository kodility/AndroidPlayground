package com.androidplayground.libbase.utils

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * Transforms the observable so the first item will be emitted right when it normally would and than debounce any following
 * items with given [timeout] and [unit].
 * @see <a href="http://reactivex.io/documentation/operators/debounce.html">ReactiveX operators documentation: Debounce</a>
 */
fun <T> Observable<T>.takeFirstThanDebounce(timeout: Long, unit: TimeUnit): Observable<T> = publish { published ->
    published
        .take(1)
        .concatWith(published.debounce(timeout, unit))
}

private class DisposableLifecycleObserver(
    private val disposable: Disposable,
    private val disposeOn: Lifecycle.Event
) : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) = onEvent(owner, Lifecycle.Event.ON_CREATE)
    override fun onResume(owner: LifecycleOwner) = onEvent(owner, Lifecycle.Event.ON_RESUME)
    override fun onStart(owner: LifecycleOwner) = onEvent(owner, Lifecycle.Event.ON_START)
    override fun onPause(owner: LifecycleOwner) = onEvent(owner, Lifecycle.Event.ON_PAUSE)
    override fun onStop(owner: LifecycleOwner) = onEvent(owner, Lifecycle.Event.ON_STOP)
    override fun onDestroy(owner: LifecycleOwner) = onEvent(owner, Lifecycle.Event.ON_DESTROY)
    private fun onEvent(owner: LifecycleOwner, event: Lifecycle.Event) {
        if (event == disposeOn || disposeOn == Lifecycle.Event.ON_ANY) {
            disposable.dispose()
            owner.lifecycle.removeObserver(this)
        }
    }
}

private val Lifecycle.State.disposeEvent: Lifecycle.Event
    get() = when (this) {
        Lifecycle.State.INITIALIZED -> Lifecycle.Event.ON_DESTROY
        Lifecycle.State.CREATED -> Lifecycle.Event.ON_DESTROY
        Lifecycle.State.STARTED -> Lifecycle.Event.ON_STOP
        Lifecycle.State.RESUMED -> Lifecycle.Event.ON_PAUSE
        else -> Lifecycle.Event.ON_ANY
    }

fun Disposable.autoDispose(
    owner: LifecycleOwner,
    event: Lifecycle.Event = owner.lifecycle.currentState.disposeEvent
): Disposable = apply { owner.lifecycle.addObserver(DisposableLifecycleObserver(this, event)) }
