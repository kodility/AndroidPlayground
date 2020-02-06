package com.monowar.androidprojecttemplate.injection.module

import com.monowar.androidprojecttemplate.ui.MainActivity
import com.monowar.libbase.injection.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All Activity that have been injected, must be declared here,
 * otherwise app will give exception during run-time.
 *
 * Other components like Fragment will have BuilderModule as @ContributesAndroidInjector to parent activities
 *
 * App can give following exceptions during run-time:
 * 1. UninitializedPropertyAccessException: lateinit property has not been initialized
 * 2. IllegalArgumentException: No injector factory bound
 */

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}