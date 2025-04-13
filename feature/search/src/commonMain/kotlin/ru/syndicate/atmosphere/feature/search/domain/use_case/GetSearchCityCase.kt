package ru.syndicate.atmosphere.feature.search.domain.use_case

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.feature.search.domain.model.City
import ru.syndicate.atmosphere.feature.search.domain.repository.SearchCityRepository
import ru.syndicate.atmosphere.feature.search.presentation.util.ErrorMessageCode

internal class GetSearchCityCase(
    private val searchCityRepository: SearchCityRepository
) {
    suspend operator fun invoke(text: String, language: String): CaseResult<List<City>> {
        return when (val response = searchCityRepository.searchCity(text, language)) {
            is ApiResponse.Failure.Error -> CaseResult.Error(ErrorMessageCode.PROBLEM_WITH_REQUEST)
            is ApiResponse.Failure.Exception -> CaseResult.Error(ErrorMessageCode.NOT_FOUND_LOCATION)
            is ApiResponse.Success<List<City>> -> {
                if (response.data.isEmpty()) CaseResult.Error(ErrorMessageCode.NOT_FOUND_LOCATION)
                else CaseResult.Success(response.data)
            }
        }
    }
}