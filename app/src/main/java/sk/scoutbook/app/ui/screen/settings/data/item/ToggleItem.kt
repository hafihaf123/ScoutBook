package sk.scoutbook.app.ui.screen.settings.data.item

import androidx.annotation.StringRes
import kotlinx.coroutines.flow.StateFlow

open class ToggleItem(
    @param:StringRes val title: Int,
    @param:StringRes val description: Int,
    val isCheckedFlow: StateFlow<Boolean>,
    val onCheckedChange: (Boolean) -> Unit,
): SettingsItem