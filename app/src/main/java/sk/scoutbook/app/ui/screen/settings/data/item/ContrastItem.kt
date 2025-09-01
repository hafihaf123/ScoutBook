package sk.scoutbook.app.ui.screen.settings.data.item

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import sk.scoutbook.app.R
import sk.scoutbook.app.ui.screen.settings.data.item.options.ContrastOption
import sk.scoutbook.app.ui.theme.ThemeViewModel

class ContrastItem(
    themeViewModel: ThemeViewModel
) : MultiChoiceItem<ContrastOption>(
    title = R.string.contrast,
    options = ContrastOption.entries,
    selectedOption = themeViewModel.run {
        contrastModeFlow.map { ContrastOption.Companion.fromContrastMode(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = ContrastOption.Companion.fromContrastMode(themeViewModel.contrastModeFlow.value)
        )
    },
    action = { option -> option.perform(themeViewModel) })