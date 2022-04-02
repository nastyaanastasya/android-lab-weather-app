package com.itis.android2.domain.usecases.weather

import com.itis.android2.domain.models.WeatherDetail
import com.itis.android2.domain.repositories.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWeatherByNameUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(name: String): WeatherDetail {
        return withContext(dispatcher) {
            weatherRepository.getWeatherByCity(name)
        }
    }
}
