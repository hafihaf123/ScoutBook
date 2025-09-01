package sk.scoutbook.app.data.language

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LanguageManager {
    private val _languageFlow = MutableStateFlow(getCurrentLanguage())
    val languageFlow: StateFlow<Language> = _languageFlow

    fun changeLanguage(language: Language) {
        val appLocale = LocaleListCompat.forLanguageTags(language.code)
        AppCompatDelegate.setApplicationLocales(appLocale)

        _languageFlow.value = language
    }

    fun getCurrentLanguage(): Language {
        val locales = AppCompatDelegate.getApplicationLocales()
        return Language.fromCode(locales.toLanguageTags()) ?: Language.ENGLISH
    }
}