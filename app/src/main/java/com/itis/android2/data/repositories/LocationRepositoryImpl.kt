package com.itis.android2.data.repositories

import android.annotation.SuppressLint
import com.google.android.gms.location.FusedLocationProviderClient
import com.itis.android2.data.api.response.Coord
import com.itis.android2.domain.repositories.LocationRepository
import javax.inject.Inject

private const val DEFAULT_LATITUDE = 55.7887
private const val DEFAULT_LONGITUDE = 49.1221

class LocationRepositoryImpl @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient
) : LocationRepository {

    private var coordinates: Coord? = null

    @SuppressLint("MissingPermission")
    override fun getCoordinates(): Coord? {
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                coordinates = Coord(location.latitude, location.longitude)
            }
        }
        return coordinates
    }

    override fun getDefaultCoordinates(): Coord {
        return Coord(
            DEFAULT_LATITUDE,
            DEFAULT_LONGITUDE
        )
    }
}
