package sk.scoutbook.app.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sk.scoutbook.app.data.theme.ThemeRepository
import sk.scoutbook.app.ui.screen.settings.data.item.options.ThemeOption
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themeRepository: ThemeRepository
) : ViewModel() {
    val themePreferencesFlow = themeRepository.themePreferencesFlow

    val selectedThemeOptionFlow = themePreferencesFlow.map { it.selectedThemeOption }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ThemeOption.SYSTEM_THEME
    )
    val dynamicColorFlow = themePreferencesFlow.map { it.dynamicColor }
        .stateIn(scope = viewModelScope, started = SharingStarted.Eagerly, initialValue = false)
    val contrastModeFlow = themePreferencesFlow.map { it.contrastMode }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ContrastMode.STANDARD
    )

    fun toggleTheme(isDarkTheme: Boolean) {
        viewModelScope.launch {
            val option = if (!isDarkTheme) ThemeOption.DARK_THEME else ThemeOption.LIGHT_THEME

            setThemeOption(option)
        }
    }

    fun setThemeOption(option: ThemeOption) {
        viewModelScope.launch {
            themeRepository.saveThemeOption(option)
        }
    }

    fun toggleDynamicColor() {
        viewModelScope.launch {
            val currentDynamicColor = dynamicColorFlow.value
            themeRepository.saveDynamicColor(!currentDynamicColor)
        }
    }

    fun setContrastMode(contrastMode: ContrastMode) {
        viewModelScope.launch {
            themeRepository.saveContrastMode(contrastMode)
        }
    }
}