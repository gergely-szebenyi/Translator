package com.prekogdevs.translator.translate.domain.translate

import com.prekogdevs.translator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}