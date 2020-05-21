package com.androidplayground.liblocaldata.injection.qualifiers

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier @Retention(RUNTIME) annotation class UserCacheSet
