package ru.syndicate.atmosphere.core.domain.use_case

sealed class CaseResult<out T> {
    data class Success<T>(val data: T) : CaseResult<T>()
    data class Error(val errorMessageCode: Int? = null) : CaseResult<Nothing>()
}