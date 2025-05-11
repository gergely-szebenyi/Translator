package com.prekogdevs.translator.android.core.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import com.prekogdevs.translator.database.TranslateDatabase
import com.prekogdevs.translator.translate.data.history.SqlDelightHistoryDataSource
import com.prekogdevs.translator.translate.data.local.DatabaseDriverFactory
import com.prekogdevs.translator.translate.data.remote.HttpClientFactory
import com.prekogdevs.translator.translate.data.translate.KtorTranslateClient
import com.prekogdevs.translator.translate.domain.history.HistoryDataSource
import com.prekogdevs.translator.translate.domain.translate.TranslateClient
import com.prekogdevs.translator.translate.domain.translate.TranslateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): TranslateUseCase {
        return TranslateUseCase(client, dataSource)
    }
}