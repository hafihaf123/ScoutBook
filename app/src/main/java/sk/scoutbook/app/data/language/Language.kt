package sk.scoutbook.app.data.language

import androidx.annotation.StringRes
import sk.scoutbook.app.R
import sk.scoutbook.app.ui.screen.settings.data.item.options.SettingsMultiChoiceOption

enum class Language(@param:StringRes override val title: Int, val code: String) :
    SettingsMultiChoiceOption<Language> {
    ENGLISH(R.string.english_language, "en"), SLOVAK(R.string.slovak_language, "sk");

    companion object {
        private val _codeMap = entries.associateBy(Language::code)

        fun fromCode(code: String): Language? = _codeMap[code]
    }
}