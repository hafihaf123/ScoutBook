package sk.scoutbook.app.ui.screen.settings.data.category.item

import sk.scoutbook.app.R
import sk.scoutbook.app.ui.theme.ThemeViewModel

class DynamicColorItem(
    val themeViewModel: ThemeViewModel
): ToggleItem(
    title = R.string.dynamic_colors_title,
    description = R.string.dynamic_colors_description,
    isCheckedFlow = themeViewModel.dynamicColorFlow,
    onCheckedChange = { themeViewModel.toggleDynamicColor() }
)