package com.androidplayground.libbase.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations

fun <T, R> LiveData<T>.switchMap(func: (T) -> LiveData<R>?): LiveData<R> = Transformations.switchMap(this, func)

fun <X, Y> LiveData<X>.map(func: (X) -> Y): LiveData<Y> = Transformations.map(this, func)

private val notSet = Any()
private val never = object : LiveData<Any>() {}

@Suppress("UNCHECKED_CAST")
private fun <T> never(): LiveData<T> {
    return never as LiveData<T>
}

@Suppress("UNCHECKED_CAST")
fun <X> LiveData<X>.observe(owner: LifecycleOwner, observer: (X) -> Unit) = observe(owner, Observer { observer(it as X) })

@Suppress("UNCHECKED_CAST")
fun <T, R> combineLatest(sources: Array<out LiveData<out T>>, combiner: (Array<T>) -> R): LiveData<R> {
    if (sources.isEmpty()) return never()

    val size = sources.size
    val result = MediatorLiveData<Any>()

    val values = arrayOfNulls<Any?>(size)
    for (index in 0 until size) values[index] = notSet

    var emits = 0
    for (index in 0 until size) {
        val observer = Observer<Any> { t ->
            var combine = emits == size
            if (!combine) {
                if (values[index] === notSet) emits++
                combine = emits == size
            }
            values[index] = t

            if (combine) {
                result.value = combiner(values as Array<T>)
            }
        }
        result.addSource(sources[index] as LiveData<Any>, observer)
    }
    return result as LiveData<R>
}

@Suppress("UNCHECKED_CAST")
fun <T1, T2, R> combineLatest(t1: LiveData<T1>, t2: LiveData<T2>, combiner: (T1, T2) -> R): LiveData<R> =
    combineLatest(arrayOf(t1, t2)) { combiner(it[0] as T1, it[1] as T2) }

@Suppress("UNCHECKED_CAST")
fun <T1, T2, T3, R> combineLatest(
    t1: LiveData<T1>,
    t2: LiveData<T2>,
    t3: LiveData<T3>,
    combiner: (T1, T2, T3) -> R
): LiveData<R> = combineLatest(arrayOf(t1, t2, t3)) { combiner(it[0] as T1, it[1] as T2, it[2] as T3) }

fun <T1, T2> combineLatest(t1: LiveData<T1>, t2: LiveData<T2>): LiveData<Pair<T1, T2>> =
    combineLatest(t1, t2) { s1, s2 -> s1 to s2 }

private class JustLiveData<T>(v: T) : LiveData<T>() {
    init {
        value = v
    }
}

fun <T> T.toLiveData(): LiveData<T> = JustLiveData(this)

@MainThread
@Suppress("UNCHECKED_CAST")
fun <T> LiveData<T>.filter(func: (T) -> Boolean): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.addSource(this) { if (func(it as T)) result.value = it }
    return result
}

@MainThread
@Suppress("UNCHECKED_CAST")
fun <T> LiveData<T?>.filterNotNull(): LiveData<T> {
    return filter { it != null } as LiveData<T>
}

@MainThread
fun <T, K> LiveData<T>.distinctUntilChanged(func: (T) -> K): LiveData<T> {
    var prev: Any? = notSet
    return filter {
        val key = func(it)
        if (key !== prev) {
            prev = key
            true
        } else {
            false
        }
    }
}

@MainThread
fun <T> LiveData<T>.distinctUntilChanged() = distinctUntilChanged { it }

@MainThread
fun <T> LiveData<T>.first(): LiveData<T> {
    return take(1)
}

@MainThread
fun <T> LiveData<T>.take(count: Int): LiveData<T> {
    if (count <= 0) return never()
    var counter = 0
    return takeUntil { ++counter >= count }
}

@MainThread
@Suppress("UNCHECKED_CAST")
fun <T> LiveData<T>.takeUntil(predicate: (T) -> Boolean): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.addSource(this) {
        if (predicate(it as T)) result.removeSource(this)
        result.value = it
    }
    return result
}

@MainThread
fun <T, S : T> LiveData<S>.startWith(value: T): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.value = value
    result.addSource(this) { result.value = it }
    return result
}
