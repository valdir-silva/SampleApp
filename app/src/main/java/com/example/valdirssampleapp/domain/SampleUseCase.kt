package com.example.valdirssampleapp.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

abstract class SampleUseCase<out T, in P> {

    abstract suspend fun execute(parameters: P): SampleResult<T>

    suspend operator fun invoke(parameters: P): SampleResult<T> = withContext(Dispatchers.IO) {
        try {
            execute(parameters)
        } catch (e: Throwable) {
            SampleResult.Failure(e)
        }
    }
}

abstract class SampleFlowUseCase<out T, in P> {

    abstract suspend fun execute(parameters: P): Flow<SampleResult<T>>

    suspend operator fun invoke(parameters: P): Flow<SampleResult<T>> =
        withContext(Dispatchers.IO) {
            try {
                execute(parameters)
            } catch (e: Throwable) {
                flowOf(SampleResult.Failure(e))
            }
        }
}
