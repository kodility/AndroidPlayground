package com.androidplayground.liblocaldata.injection.module

import android.content.Context
import com.androidplayground.libcommon.injection.qualifires.ApplicationContext
import com.androidplayground.liblocaldata.injection.qualifiers.ApplicationCacheSet
import com.androidplayground.liblocaldata.injection.qualifiers.UserCacheSet
import com.androidplayground.liblocaldata.keyvaluestore.sharedpreference.SharedPreferenceStore
import com.androidplayground.liblocaldata.keyvaluestore.sharedpreference.SharedPreferenceStoreImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Mostafa Monowar at 03-May-20 5:30 PM
 * monowar1993@gmail.com
 */
@Module
object KeyValueStoreModule {
    @Provides
    @Singleton
    @ApplicationCacheSet
    fun provideSharedPreferenceStoreApplication(@ApplicationContext context: Context): SharedPreferenceStore {
        return SharedPreferenceStoreImpl(context, "shared_preference_application")
    }

    @Provides
    @Singleton
    @UserCacheSet
    fun provideSharedPreferenceStoreUser(@ApplicationContext context: Context): SharedPreferenceStore {
        return SharedPreferenceStoreImpl(context, "shared_preference_user")
    }
}
