package com.babyapps.wondrium.injection

import com.babyapps.wondrium.data.api.WondriumApi
import com.babyapps.wondrium.data.repository.WondriumRepository
import com.babyapps.wondrium.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideWondriumApi(): WondriumApi = Retrofit.Builder().baseUrl(Constants.COURSES_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build().create(WondriumApi::class.java)

    @Provides
    fun provideRepository(wondriumApi: WondriumApi): WondriumRepository = WondriumRepository(wondriumApi)

}