package sk.scoutbook.app.ui.screen.settings.data.item

import sk.scoutbook.app.R
import sk.scoutbook.app.data.language.Language
import sk.scoutbook.app.data.language.LanguageManager

class LanguageItem(languageManager: LanguageManager) : MultiChoiceItem<Language>(
    title = R.string.language_item_title,
    options = Language.entries,
    selectedOption = languageManager.languageFlow,
    action = { language -> languageManager.changeLanguage(language) })