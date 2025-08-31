package sk.scoutbook.app.data.theme

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import sk.scoutbook.app.ui.screen.settings.data.category.item.options.ThemeOption
import sk.scoutbook.app.ui.theme.ContrastMode
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "theme")

@Singleton
class ThemeRepository @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    val themePreferencesFlow: Flow<ThemePreferences> = context.dataStore.data.catch { exception ->
        if (exception is IOException) emit(emptyPreferences())
        else throw exception
    }.map { preferences ->
        ThemePreferences(
            isDarkTheme = preferences[ThemePreferencesKeys.IS_DARK_THEME] ?: false,
            selectedThemeOption = preferences[ThemePreferencesKeys.SELECTED_THEME_OPTION]?.let {
                ThemeOption.valueOf(
                    it
                )
            } ?: ThemeOption.SYSTEM_THEME,
            dynamicColor = preferences[ThemePreferencesKeys.DYNAMIC_COLOR] ?: false,
            contrastMode = preferences[ThemePreferencesKeys.CONTRAST_MODE]?.let {
                ContrastMode.valueOf(
                    it
                )
            } ?: ContrastMode.STANDARD)
    }

    suspend fun saveThemeOption(themeOption: ThemeOption, systemTheme: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ThemePreferencesKeys.SELECTED_THEME_OPTION] = themeOption.name
        }
    }

    suspend fun saveDynamicColor(dynamicColor: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ThemePreferencesKeys.DYNAMIC_COLOR] = dynamicColor
        }
    }

    suspend fun saveContrastMode(constrastMode: ContrastMode) {
        context.dataStore.edit { preferences ->
            preferences[ThemePreferencesKeys.CONTRAST_MODE] = constrastMode.name
        }
    }
}

data class ThemePreferences(
    val isDarkTheme: Boolean,
    val selectedThemeOption: ThemeOption,
    val dynamicColor: Boolean,
    val contrastMode: ContrastMode
)