package com.itis.android2.di.modules

import com.itis.android2.data.api.mappers.WeatherMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideWeatherMapper(): WeatherMapper = WeatherMapper()
}
