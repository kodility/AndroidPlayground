package com.androidplayground.corelocaldata.keyvaluestore

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

/**
 * Created by Mostafa Monowar at 03-May-20 3:34 PM
 * monowar1993@gmail.com
 */
class SharedPreferenceStore(applicationContext: Context, name: String) : KeyValueStore {

    private val sharedPreferences: SharedPreferences by lazy {
        applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    override fun put(key: String, value: Boolean): Completable {
        return Completable.fromAction { sharedPreferences.edit { putBoolean(key, value) } }
    }

    override fun put(key: String, value: Int): Completable {
        return Completable.fromAction { sharedPreferences.edit { putInt(key, value) } }
    }

    override fun put(key: String, value: Long): Completable {
        return Completable.fromAction { sharedPreferences.edit { putLong(key, value) } }
    }

    override fun put(key: String, value: Float): Completable {
        return Completable.fromAction { sharedPreferences.edit { putFloat(key, value) } }
    }

    override fun put(key: String, value: Double): Completable {
        return Completable.error(RuntimeException("SharedPreferences do not support Double data type."))
    }

    override fun put(key: String, value: String): Completable {
        return Completable.fromAction { sharedPreferences.edit { putString(key, value) } }
    }

    override fun getBoolean(key: String): Maybe<Boolean> {
        return Maybe.create { emitter ->
            try {
                val value = sharedPreferences.getBoolean(key, false)
                if (!value) {
                    emitter.onError(NullPointerException("No value is stored using key $key"))
                } else {
                    emitter.onSuccess(value)
                }
            } catch (e: ClassCastException) {
                emitter.onError(e)
            }
        }
    }

    override fun getInt(key: String): Maybe<Int> {
        return Maybe.create { emitter ->
            try {
                val value = sharedPreferences.getInt(key, Int.MIN_VALUE)
                if (value == Int.MIN_VALUE) {
                    emitter.onError(NullPointerException("No value is stored using key $key"))
                } else {
                    emitter.onSuccess(value)
                }
            } catch (e: ClassCastException) {
                emitter.onError(e)
            }
        }
    }

    override fun getLong(key: String): Maybe<Long> {
        return Maybe.create { emitter ->
            try {
                val value = sharedPreferences.getLong(key, Long.MIN_VALUE)
                if (value == Long.MIN_VALUE) {
                    emitter.onError(NullPointerException("No value is stored using key $key"))
                } else {
                    emitter.onSuccess(value)
                }
            } catch (e: ClassCastException) {
                emitter.onError(e)
            }
        }
    }

    override fun getFloat(key: String): Maybe<Float> {
        return Maybe.create { emitter ->
            try {
                val value = sharedPreferences.getFloat(key, Float.MIN_VALUE)
                if (value == Float.MIN_VALUE) {
                    emitter.onError(NullPointerException("No value is stored using key $key"))
                } else {
                    emitter.onSuccess(value)
                }
            } catch (e: ClassCastException) {
                emitter.onError(e)
            }
        }
    }

    override fun getDouble(key: String): Maybe<Double> {
        return Maybe.error(RuntimeException("SharedPreferences do not support Double data type."))
    }

    override fun getString(key: String): Maybe<String> {
        return Maybe.create { emitter ->
            try {
                sharedPreferences.getString(key, null)?.let {
                    emitter.onSuccess(it)
                } ?: run {
                    emitter.onError(NullPointerException("No value is stored using key $key"))
                }
            } catch (e: ClassCastException) {
                emitter.onError(e)
            }
        }
    }

    override fun remove(key: String): Completable {
        return Completable.fromAction { sharedPreferences.edit { remove(key) } }
    }

    override fun clear(): Completable {
        return Completable.fromAction { sharedPreferences.edit { clear() } }
    }
}
