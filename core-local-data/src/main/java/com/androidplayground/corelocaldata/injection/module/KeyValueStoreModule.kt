package com.androidplayground.corelocaldata.injection.module

import com.androidplayground.corelocaldata.injection.qualifiers.ApplicationCacheSet
import com.androidplayground.corelocaldata.injection.qualifiers.UserCacheSet
import com.androidplayground.corelocaldata.keyvaluestore.KeyValueStore
import com.androidplayground.corelocaldata.keyvaluestore.KeyValueStoreFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Mostafa Monowar at 03-May-20 5:30 PM
 * monowar1993@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class KeyValueStoreModule {
    @Binds
    @ApplicationCacheSet
    abstract fun bindApplicationKeyValueStoreFactory(keyValueStoreFactory: KeyValueStoreFactory): KeyValueStore.Factory

    @Binds
    @UserCacheSet
    abstract fun bindUserKeyValueStoreFactory(keyValueStoreFactory: KeyValueStoreFactory): KeyValueStore.Factory
}
