package com.prekogdevs.translator.translate.presentation

import com.prekogdevs.translator.core.presentation.UiLanguage

sealed class TranslateEvent {
    data class ChooseFromLanguage(val language: UiLanguage): TranslateEvent()
    data class ChooseToLanguage(val language: UiLanguage): TranslateEvent()
    data class ChangeTranslationText(val text: String): TranslateEvent()
    data class SelectHistoryItem(val item: UiHistoryItem): TranslateEvent()
    data class SubmitVoiceResult(val result: String?): TranslateEvent()
    data object StopChoosingLanguage: TranslateEvent()
    data object SwapLanguages: TranslateEvent()
    data object Translate: TranslateEvent()
    data object OpenFromLanguageDropDown: TranslateEvent()
    data object OpenToLanguageDropDown: TranslateEvent()
    data object CloseTranslation: TranslateEvent()
    data object EditTranslation: TranslateEvent()
    data object RecordAudio: TranslateEvent()
    data object OnErrorSeen: TranslateEvent()
}