package com.androidplayground.corelocaldata.injection.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Mostafa Monowar at 03-May-20 5:30 PM
 * monowar1993@gmail.com
 */
@Module(
    includes = [
        KeyValueStoreModule::class
    ]
)
@InstallIn(SingletonComponent::class)
abstract class LocalDataModule
