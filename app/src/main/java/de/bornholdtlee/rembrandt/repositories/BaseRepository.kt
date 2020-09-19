package de.bornholdtlee.rembrandt.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.KoinComponent

abstract class BaseRepository : KoinComponent {

    private val job = SupervisorJob()
    protected val repositoryScope = CoroutineScope(Dispatchers.Main + job)

//    protected val api: ApiInterface by inject()

//    suspend fun <T> apiCall(block: suspend ApiInterface.() -> Response<T>): ResponseEvaluator.HTTPResponseEvaluation<T> {
//        return ResponseEvaluator.evaluate(
//            try {
//                withContext(Dispatchers.IO) { block(api) }
//            } catch (e: Exception) {
//                null
//            }
//        )
//    }
}
