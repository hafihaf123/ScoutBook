package sk.scoutbook.app.ui.screen.settings.data.item

import sk.scoutbook.app.R
import sk.scoutbook.app.ui.screen.settings.data.item.options.ThemeOption
import sk.scoutbook.app.ui.theme.ThemeViewModel

class ThemeItem(
    themeViewModel: ThemeViewModel
): MultiChoiceItem<ThemeOption>(
    title = R.string.theme,
    options = ThemeOption.entries,
    selectedOption = themeViewModel.selectedThemeOptionFlow,
    action = { option -> option.perform(themeViewModel) }
)