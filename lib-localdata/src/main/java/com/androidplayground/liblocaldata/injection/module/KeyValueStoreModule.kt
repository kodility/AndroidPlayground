package com.androidplayground.liblocaldata.injection.module

import com.androidplayground.liblocaldata.injection.qualifiers.ApplicationCacheSet
import com.androidplayground.liblocaldata.injection.qualifiers.UserCacheSet
import com.androidplayground.liblocaldata.keyvaluestore.KeyValueStore
import com.androidplayground.liblocaldata.keyvaluestore.KeyValueStoreFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Mostafa Monowar at 03-May-20 5:30 PM
 * monowar1993@gmail.com
 */
@Module
abstract class KeyValueStoreModule {
    @Binds
    @ApplicationCacheSet
    abstract fun bindApplicationKeyValueStoreFactory(keyValueStoreFactory: KeyValueStoreFactory): KeyValueStore.Factory

    @Binds
    @UserCacheSet
    abstract fun bindUserKeyValueStoreFactory(keyValueStoreFactory: KeyValueStoreFactory): KeyValueStore.Factory
}
