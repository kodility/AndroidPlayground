package com.androidplayground.librepository.injection

import com.androidplayground.libapi.injection.ApiModule
import com.androidplayground.liblocaldata.injection.module.LocalDataModule
import dagger.Module

/**
 * Created by Mostafa Monowar at 03-May-20 5:57 PM
 * monowar1993@gmail.com
 */
@Module(
    includes = [
        ApiModule::class,
        LocalDataModule::class
    ]
)
abstract class RepositoryModule
