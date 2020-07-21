package com.androidplayground.coreapi.injection

import com.androidplayground.coreapi.ApiFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by Mostafa Monowar at 03-May-20 5:47 PM
 * monowar1993@gmail.com
 */
@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providesMoshi(): Moshi = ApiFactory.moshi
}
