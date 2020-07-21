package com.androidplayground.librepository.injection

import com.androidplayground.coreapi.injection.ApiModule
import com.androidplayground.corelocaldata.injection.module.LocalDataModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

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
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule
