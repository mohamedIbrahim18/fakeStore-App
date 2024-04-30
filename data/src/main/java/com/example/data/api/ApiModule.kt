package com.example.data.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor {
            Log.e("api", it)
        }
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Named("retrofitForProductsSimple")
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Named("webServiceProducts")
    fun provideWebServices(
        @Named("retrofitForProductsSimple")
        retrofit: Retrofit
    ): WebServices {
        return retrofit.create(WebServices::class.java)
    }

    @Provides
    @Named("retrofitForProducts")
    fun provideRetrofitCategories(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://fakestoreapi.com/products/")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Named("webServicesCategories")
    fun provideWebServicesCategories(
        @Named("retrofitForProducts")
        retrofitT: Retrofit
    ): WebServices {
        return retrofitT.create(WebServices::class.java)
    }

    @Provides
    @Named("webServicesForSpecificProducts")
    fun provideWebServicesForSpecificProducts(
        @Named("retrofitForProducts")
        retrofitT: Retrofit
    ): WebServices {
        return retrofitT.create(WebServices::class.java)
    }

    @Provides
    @Named("webServicesForSingleProduct")
    fun provideWebServicesForSingleProduct(
        @Named("retrofitForProducts")
        retrofitT: Retrofit
    ): WebServices {
        return retrofitT.create(WebServices::class.java)
    }

}
