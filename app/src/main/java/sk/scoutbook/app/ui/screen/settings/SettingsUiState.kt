package sk.scoutbook.app.ui.screen.settings

import sk.scoutbook.app.ui.screen.settings.data.SettingsCategory

data class SettingsUiState(
    var categories: List<SettingsCategory> = emptyList()
)