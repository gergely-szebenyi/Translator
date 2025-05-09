package com.prekogdevs.translator.core.domain.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow

expect class CommonStateFlow<T>(flow: StateFlow<T>) : StateFlow<T> {
    override val value: T //from StateFlow
    override suspend fun collect(collector: FlowCollector<T>): Nothing // from SharedFlow
    override val replayCache: List<T> // from SharedFlow
}

fun <T> StateFlow<T>.toCommonStateFlow() = CommonStateFlow(this)