package sk.scoutbook.app.ui.screen.settings.data.item

import androidx.annotation.StringRes
import kotlinx.coroutines.flow.StateFlow
import sk.scoutbook.app.ui.screen.settings.data.item.options.SettingsMultiChoiceOption

open class MultiChoiceItem<T>(
    @param:StringRes val title: Int,
    val options: List<T>,
    var selectedOption: StateFlow<T>,
    val action: (T) -> Unit
) : SettingsItem where T : Enum<T>, T : SettingsMultiChoiceOption<T>