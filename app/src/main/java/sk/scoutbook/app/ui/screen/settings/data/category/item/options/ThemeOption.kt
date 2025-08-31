package sk.scoutbook.app.ui.screen.settings.data.category.item.options

import sk.scoutbook.app.R
import sk.scoutbook.app.ui.theme.ThemeViewModel

enum class ThemeOption(val isDarkTheme: Boolean?) : SettingsMultiChoiceOption<ThemeOption> {
    DARK_THEME(true) {
        override val title = R.string.dark_theme
    },
    LIGHT_THEME(false) {
        override val title = R.string.light_theme
    },
    SYSTEM_THEME(null) {
        override val title = R.string.system_theme
    };

    fun perform(themeViewModel: ThemeViewModel, systemTheme: Boolean) {
        themeViewModel.setThemeOption(this, systemTheme)
    }
}