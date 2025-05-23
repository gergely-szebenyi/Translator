package com.prekogdevs.translator.di

import com.prekogdevs.translator.testing.FakeHistoryDataSource
import com.prekogdevs.translator.testing.FakeTranslateClient
import com.prekogdevs.translator.testing.FakeVoiceToTextParser
import com.prekogdevs.translator.translate.domain.translate.TranslateUseCase

class TestAppModule: AppModule {
    override val historyDataSource = FakeHistoryDataSource()
    override val client = FakeTranslateClient()
    override val translateUseCase = TranslateUseCase(client, historyDataSource)
    override val voiceParser = FakeVoiceToTextParser()
}