package com.androidplayground.corelocaldata.keyvaluestore

import android.content.Context
import com.androidplayground.corelocaldata.keyvaluestore.KeyValueStore.Type.SHARED_PREFERENCE
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mostafa Monowar at 09-May-20 3:06 AM
 * monowar1993@gmail.com
 */
@Singleton
class KeyValueStoreFactory @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) : KeyValueStore.Factory {
    override fun create(name: KeyValueStore.Name, type: KeyValueStore.Type): KeyValueStore {
        return if (type == SHARED_PREFERENCE) SharedPreferenceStore(applicationContext, name.storeName)
        else throw IllegalArgumentException("$type not supported yet.")
    }
}
