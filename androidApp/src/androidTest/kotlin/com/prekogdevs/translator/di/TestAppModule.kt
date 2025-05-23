package com.prekogdevs.translator.di

import com.prekogdevs.translator.translate.data.local.FakeHistoryDataSource
import com.prekogdevs.translator.translate.data.remote.FakeTranslateClient
import com.prekogdevs.translator.translate.domain.history.HistoryDataSource
import com.prekogdevs.translator.translate.domain.translate.TranslateClient
import com.prekogdevs.translator.translate.domain.translate.TranslateUseCase
import com.prekogdevs.translator.voice_to_text.data.FakeVoiceToTextParser
import com.prekogdevs.translator.voice_to_text.domain.VoiceToTextParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideFakeTranslateClient(): TranslateClient {
        return FakeTranslateClient()
    }

    @Provides
    @Singleton
    fun provideFakeHistoryDataSource(): HistoryDataSource {
        return FakeHistoryDataSource()
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): TranslateUseCase {
        return TranslateUseCase(client, dataSource)
    }

    @Provides
    @Singleton
    fun provideFakeVoiceToTextParser(): VoiceToTextParser {
        return FakeVoiceToTextParser()
    }
}