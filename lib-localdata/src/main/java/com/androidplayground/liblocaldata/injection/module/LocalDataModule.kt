package com.androidplayground.liblocaldata.injection.module

import dagger.Module

/**
 * Created by Mostafa Monowar at 03-May-20 5:30 PM
 * monowar1993@gmail.com
 */
@Module(
    includes = [
        KeyValueStoreModule::class
    ]
)
abstract class LocalDataModule
