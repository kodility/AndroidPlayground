package com.androidplayground.liblocaldata.keyvaluestore

import com.androidplayground.liblocaldata.Clearable
import io.reactivex.rxjava3.annotations.CheckReturnValue
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

/**
 * Created by Mostafa Monowar at 03-May-20 2:19 PM
 * monowar1993@gmail.com
 *
 * The key value store should be able to store all basic data types.
 */
interface KeyValueStore : Clearable {
    @CheckReturnValue
    fun put(key: String, value: Boolean): Completable

    @CheckReturnValue
    fun put(key: String, value: Int): Completable

    @CheckReturnValue
    fun put(key: String, value: Long): Completable

    @CheckReturnValue
    fun put(key: String, value: Float): Completable

    @CheckReturnValue
    fun put(key: String, value: Double): Completable

    @CheckReturnValue
    fun put(key: String, value: String): Completable

    @CheckReturnValue
    fun getBoolean(key: String): Maybe<Boolean>

    @CheckReturnValue
    fun getInt(key: String): Maybe<Int>

    @CheckReturnValue
    fun getLong(key: String): Maybe<Long>

    @CheckReturnValue
    fun getFloat(key: String): Maybe<Float>

    @CheckReturnValue
    fun getDouble(key: String): Maybe<Double>

    @CheckReturnValue
    fun getString(key: String): Maybe<String>

    @CheckReturnValue
    fun remove(key: String): Completable
}
