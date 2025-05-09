package com.prekogdevs.translator.translate.domain.history

import com.prekogdevs.translator.core.domain.util.CommonFlow
import kotlin.coroutines.CoroutineContext

interface HistoryDataSource {
    fun getHistory(context: CoroutineContext): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}