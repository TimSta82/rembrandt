package de.bornholdtlee.rembrandt.usecases

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.KoinComponent

abstract class BaseUseCase : KoinComponent {

    private val job = SupervisorJob()
    protected val useCaseScope = CoroutineScope(Dispatchers.Main + job)

    sealed class UseCaseResult<T> {
        data class Success<T>(val resultObject: T) : UseCaseResult<T>()
        class Failure<T> : UseCaseResult<T>()
    }

//    fun <T> responseCall(httpResponseEvaluation: ResponseEvaluator.HTTPResponseEvaluation<T>): UseCaseResult<T> {
//        return when (httpResponseEvaluation) {
//            is ResponseEvaluator.HTTPResponseEvaluation.Success -> httpResponseEvaluation.response.body()?.let { UseCaseResult.Success(it) } ?: UseCaseResult.Failure()
//            else -> UseCaseResult.Failure()
//        }
//    }
//
//    suspend fun <T, S> simpleResponseCall(httpResponseEvaluation: ResponseEvaluator.HTTPResponseEvaluation<T>, onSuccess: suspend (t: T) -> S): UseCaseResult<S> {
//        return when (httpResponseEvaluation) {
//            is ResponseEvaluator.HTTPResponseEvaluation.Success -> httpResponseEvaluation.response.body()?.let { UseCaseResult.Success(onSuccess(it)) } ?: UseCaseResult.Failure()
//            else -> UseCaseResult.Failure()
//        }
//    }
}
