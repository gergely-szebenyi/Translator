package com.prekogdevs.translator.core.domain.util

import com.prekogdevs.translator.core.domain.util.CommonStateFlow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

actual open class CommonMutableStateFlow<T> actual constructor(
    private val flow: MutableStateFlow<T>
) : CommonStateFlow<T>(flow), MutableStateFlow<T> {

    actual override var value: T
        get() = super.value
        set(value) {
            flow.value = value
        }

    actual override val subscriptionCount: StateFlow<Int>
        get() = flow.subscriptionCount

    actual override fun compareAndSet(expect: T, update: T): Boolean {
        return flow.compareAndSet(expect, update)
    }

    @ExperimentalCoroutinesApi
    actual override fun resetReplayCache() {
        flow.resetReplayCache()
    }

    actual override fun tryEmit(value: T): Boolean {
        return flow.tryEmit(value)
    }

    actual override suspend fun emit(value: T) {
        flow.emit(value)
    }
}