package sk.scoutbook.app.data.theme

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object ThemePreferencesKeys {
    val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")
    val SELECTED_THEME_OPTION = stringPreferencesKey("selected_theme_option")
    val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
    val CONTRAST_MODE = stringPreferencesKey("contrast_mode")
}