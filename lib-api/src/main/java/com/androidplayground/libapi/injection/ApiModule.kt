package com.androidplayground.libapi.injection

import com.androidplayground.libapi.ApiFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Mostafa Monowar at 03-May-20 5:47 PM
 * monowar1993@gmail.com
 */
@Module
object ApiModule {
    @Provides
    @Singleton
    fun providesMoshi(): Moshi = ApiFactory.moshi
}
