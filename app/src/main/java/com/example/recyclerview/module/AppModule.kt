package com.example.recyclerview.module

import android.util.Log
import com.example.recyclerview.BuildConfig
import com.example.recyclerview.common.StringConstant
import com.example.recyclerview.data.remote.MovieApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        provideOkHttpClient()
    }
    single {
        provideRetrofit(get())
    }
    single {
        provideApi(get())
    }
}

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.d("This is data: ", message)
        }
    })
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit = Retrofit
    .Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(StringConstant.BASE_URL)
    .client(okHttpClient)
    .build()

private fun provideApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)
