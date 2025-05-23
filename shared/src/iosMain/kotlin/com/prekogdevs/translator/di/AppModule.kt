package com.prekogdevs.translator.di

import com.prekogdevs.translator.database.TranslateDatabase
import com.prekogdevs.translator.translate.data.history.SqlDelightHistoryDataSource
import com.prekogdevs.translator.translate.data.local.DatabaseDriverFactory
import com.prekogdevs.translator.translate.data.remote.HttpClientFactory
import com.prekogdevs.translator.translate.data.translate.KtorTranslateClient
import com.prekogdevs.translator.translate.domain.history.HistoryDataSource
import com.prekogdevs.translator.translate.domain.translate.TranslateClient
import com.prekogdevs.translator.translate.domain.translate.TranslateUseCase
import com.prekogdevs.translator.voice_to_text.domain.VoiceToTextParser

interface AppModule {
    val historyDataSource: HistoryDataSource
    val client: TranslateClient
    val translateUseCase: TranslateUseCase
    val voiceParser: VoiceToTextParser
}

class AppModuleImpl(
    parser: VoiceToTextParser
): AppModule {

    override val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    override val client: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    override val translateUseCase: TranslateUseCase by lazy {
        TranslateUseCase(client, historyDataSource)
    }

    override val voiceParser = parser
}