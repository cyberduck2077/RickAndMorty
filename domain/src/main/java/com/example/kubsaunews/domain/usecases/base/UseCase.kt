package com.example.kubsaunews.domain.usecases.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class UseCase<T, Params> {

    protected abstract suspend fun buildUseCase(params: Params): T
    protected abstract val reportUseCaseName: String // Proguard renames the name of inherited class

    fun execute(
        params: Params,
        scope: CoroutineScope,
        onSuccess: suspend (T) -> Unit,
        onError: suspend (e: Exception) -> Unit,
        executeContext: CoroutineContext = Dispatchers.IO,
        resultContext: CoroutineContext = Dispatchers.Main
    ) =
        scope.launch(executeContext) {
            try {
                val result = buildUseCase(params)
                withContext(resultContext) {
                    onSuccess(result)
                }
            } catch (e: Exception) {
//                Log.e(TAG, e.message.toString()) настроить логирование
                print("$TAG, ${e.message.toString()}")
//                Analytics.useCaseError(
//                    reportUseCaseName,
//                    e
//                )
                withContext(resultContext) {
                    onError(e)
                }
            }
        }

    class None

    companion object {
        private const val TAG = "UseCase"
    }

}