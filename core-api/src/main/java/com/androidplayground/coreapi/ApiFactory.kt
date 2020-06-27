package com.androidplayground.coreapi

import android.content.Context
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.squareup.moshi.Moshi
import java.util.concurrent.TimeUnit
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Mostafa Monowar at 05-Apr-20 6:48 PM
 * monowar1993@gmail.com
 */
object ApiFactory {
    private const val TIME_OUT = 30L

    private const val cacheSize: Long = 10 * 1024 * 1024 // 10 MB

    val moshi: Moshi by lazy { Moshi.Builder().build() }

    fun <Service> createService(serviceClass: Class<Service>, retrofit: Retrofit): Service {
        return retrofit.create(serviceClass)
    }

    fun getRetrofit(baseUrl: String, okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun getOkHttpClientBuilder(
        applicationContext: Context,
        timeOut: Long = TIME_OUT,
        isDebug: Boolean,
        logTag: String
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(
                LoggingInterceptor.Builder()
                    .setLevel(if (isDebug) Level.BASIC else Level.NONE)
                    .log(Platform.INFO)
                    .tag(logTag)
                    .request("Request")
                    .response("Response")
                    .build()
            )
            .cache(getCache(applicationContext))
    }

    private fun getCache(context: Context) = Cache(context.cacheDir, cacheSize)
}
