package com.prekogdevs.translator.di

import com.prekogdevs.translator.database.TranslateDatabase
import com.prekogdevs.translator.translate.data.history.SqlDelightHistoryDataSource
import com.prekogdevs.translator.translate.data.local.DatabaseDriverFactory
import com.prekogdevs.translator.translate.data.remote.HttpClientFactory
import com.prekogdevs.translator.translate.data.translate.KtorTranslateClient
import com.prekogdevs.translator.translate.domain.history.HistoryDataSource
import com.prekogdevs.translator.translate.domain.translate.TranslateClient
import com.prekogdevs.translator.translate.domain.translate.TranslateUseCase

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translateUseCase: TranslateUseCase by lazy {
        TranslateUseCase(translateClient, historyDataSource)
    }
}