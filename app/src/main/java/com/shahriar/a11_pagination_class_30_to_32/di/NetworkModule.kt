package com.shahriar.a11_pagination_class_30_to_32.di

import com.shahriar.a11_pagination_class_30_to_32.Constants
import com.shahriar.a11_pagination_class_30_to_32.api.QuotesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofitBuilder(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun getQuotesApi(retrofit: Retrofit.Builder): QuotesApi{
        return retrofit.build().create(QuotesApi::class.java)
    }
}