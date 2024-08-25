@file:Suppress("UNCHECKED_CAST")

package com.example.valdirssampleapp.domain

sealed class SampleResult<out R>(val content: R? = null) {
    data class Success<out R>(val value: R) : SampleResult<R>(value)
    data class Failure(val throwable: Throwable? = null) : SampleResult<Nothing>()

    data class Loading(val unit: Unit = Unit) : SampleResult<Nothing>()

    val isSuccess: Boolean
        get() = this is Success

    val isFailure: Boolean
        get() = this is Failure

    val isLoading: Boolean
        get() = this is Loading

    fun getOrNull(): R? = when (this) {
        is Success -> content
        else -> null
    }

    fun throwableOrNull(): Throwable? = when (this) {
        is Failure -> throwable
        else -> null
    }
}

inline fun <T> onResult(block: () -> T): SampleResult<T> {
    return try {
        SampleResult.Success(requireNotNull(block()))
    } catch (e: Throwable) {
        SampleResult.Failure(e)
    }
}

inline fun <T> SampleResult<T>.onResultSuccess(block: (T) -> Unit): SampleResult<T> {
    return takeIf { isSuccess }?.let {
        onResult {
            block(requireNotNull(content as T))
        }.throwableOrNull()
    }?.let { throwable ->
        SampleResult.Failure(throwable)
    } ?: this
}

inline fun <T> SampleResult<T>.onResultFailure(block: (Throwable) -> Unit): SampleResult<T> {
    return throwableOrNull()?.let { throwable ->
        onResult {
            block(throwable)
        }.throwableOrNull()
    }?.let { throwable ->
        SampleResult.Failure(throwable)
    } ?: this
}
