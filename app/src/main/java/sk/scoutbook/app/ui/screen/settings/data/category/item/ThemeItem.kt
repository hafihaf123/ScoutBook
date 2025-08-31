package sk.scoutbook.app.ui.screen.settings.data.category.item

import sk.scoutbook.app.R
import sk.scoutbook.app.ui.screen.settings.data.category.item.options.ThemeOption
import sk.scoutbook.app.ui.theme.ThemeViewModel

class ThemeItem(
    themeViewModel: ThemeViewModel,
    systemTheme: Boolean
): MultiChoiceItem<ThemeOption>(
    title = R.string.theme,
    options = ThemeOption.entries,
    selectedOption = themeViewModel.selectedThemeOptionFlow,
    action = { option -> option.perform(themeViewModel, systemTheme) }
)