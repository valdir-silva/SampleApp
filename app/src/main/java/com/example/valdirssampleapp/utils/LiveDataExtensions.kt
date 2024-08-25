package com.example.valdirssampleapp.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

data class SingleEventLiveData<out T>(private val data: T) {
    private var eventHasBeenHandled = false

    val contentOrNullIfHandled: T?
        get() = if (eventHasBeenHandled) {
            null
        } else {
            eventHasBeenHandled = true
            data
        }

    fun peekContent(): T? = data
}

fun <T> LiveData<T>.observeOnce(owner: LifecycleOwner, observer: Observer<in T>) {
    val lifecycleObserver = object : Observer<T> {
        override fun onChanged(value: T) {
            removeObserver(this)
            observer.onChanged(value)
        }
    }
    observe(owner, lifecycleObserver)
}

fun <T> MutableLiveData<SingleEventLiveData<T>>.postSingleEvent(data: T) {
    value = SingleEventLiveData(data)
}

fun MutableLiveData<SingleEventLiveData<Unit>>.postSingleEvent() {
    value = SingleEventLiveData(Unit)
}

fun <T> LiveData<SingleEventLiveData<T>>.observeSingleEvent(owner: LifecycleOwner, onChanged: (T) -> Unit) {
    observe(
        owner,
    ) {
        it?.contentOrNullIfHandled?.let { content ->
            onChanged(content)
        }
    }
}

fun <T> MutableLiveData<T>.toLiveData(): LiveData<T> {
    return this
}
