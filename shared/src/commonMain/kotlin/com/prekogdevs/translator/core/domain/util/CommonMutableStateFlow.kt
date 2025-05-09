package com.prekogdevs.translator.core.domain.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

expect class CommonMutableStateFlow<T>(flow: MutableStateFlow<T>) : MutableStateFlow<T> {
    override var value: T // from MutableStateFlow
    override fun compareAndSet(expect: T, update: T): Boolean // from MutableStateFlow
    override suspend fun emit(value: T) // from MutableSharedFlow
    override fun tryEmit(value: T): Boolean // from MutableSharedFlow
    override val subscriptionCount: StateFlow<Int> // from MutableSharedFlow

    @ExperimentalCoroutinesApi
    override fun resetReplayCache() // from MutableSharedFlow
    override val replayCache: List<T> // from SharedFlow
    override suspend fun collect(collector: FlowCollector<T>): Nothing // from SharedFlow
}

fun <T> MutableStateFlow<T>.toCommonMutableStateFlow() = CommonMutableStateFlow(this)