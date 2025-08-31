package sk.scoutbook.app.ui.screen.settings

import sk.scoutbook.app.ui.screen.settings.data.category.SettingsCategory

data class SettingsUiState(
    var categories: List<SettingsCategory> = emptyList()
)