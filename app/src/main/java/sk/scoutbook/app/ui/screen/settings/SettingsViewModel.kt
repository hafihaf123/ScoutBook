package sk.scoutbook.app.ui.screen.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sk.scoutbook.app.ui.screen.settings.data.category.AppearanceCategory
import sk.scoutbook.app.ui.screen.settings.data.category.SettingsCategory
import sk.scoutbook.app.ui.theme.ThemeViewModel

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    fun loadSettings(themeViewModel: ThemeViewModel, systemTheme: Boolean) {
        val categories: List<SettingsCategory> = listOf(
            AppearanceCategory(themeViewModel, systemTheme)
        )
        viewModelScope.launch {
            _uiState.value = SettingsUiState(categories = categories)
        }
    }
}