package com.androidplayground.corelocaldata.keyvaluestore

import com.androidplayground.corelocaldata.Clearable
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

    interface Factory {
        fun create(name: Name, type: Type): KeyValueStore
    }

    enum class Type {
        ROOM_DATABASE,
        SHARED_PREFERENCE,
        IN_MEMORY
    }

    enum class Name(val storeName: String) {
        APP_ROOM_DATABASE("app_key_value_database"),
        USER_ROOM_DATABASE("user_key_value_database"),
        APP_SHARED_PREFERENCE("app_shared_preference"),
        USER_SHARED_PREFERENCE("user_shared_preference"),
        IN_MEMORY("in_memory_cache")
    }
}
