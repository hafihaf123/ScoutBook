package sk.scoutbook.app.ui.screen.settings.data

import sk.scoutbook.app.R
import sk.scoutbook.app.data.language.LanguageManager
import sk.scoutbook.app.ui.screen.settings.data.item.LanguageItem

class LocalizationCategory(languageManager: LanguageManager = LanguageManager()) : SettingsCategory(
    title = R.string.localization_title,
    icon = R.drawable.language_24px,
    subcategories = listOf(LanguageItem(languageManager))
)