package com.prekogdevs.translator.testing

import com.prekogdevs.translator.core.domain.language.Language
import com.prekogdevs.translator.translate.domain.translate.TranslateClient

class FakeTranslateClient: TranslateClient {

    var translatedText = "test translation"

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        return translatedText
    }
}