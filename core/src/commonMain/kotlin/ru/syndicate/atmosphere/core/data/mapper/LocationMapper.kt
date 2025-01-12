package ru.syndicate.atmosphere.core.data.mapper

import ru.syndicate.atmosphere.core.data.dto.CurrentLocationDTO
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation

fun CurrentLocationDTO.toModel() = CurrentLocation(
    title, timeZone, latitude, longitude
)

fun CurrentLocation.toDTO() = CurrentLocationDTO(
    title, timeZone, latitude, longitude
)