package sk.scoutbook.app.ui.screen.settings.data

import sk.scoutbook.app.R
import sk.scoutbook.app.ui.screen.settings.data.item.ContrastItem
import sk.scoutbook.app.ui.screen.settings.data.item.DynamicColorItem
import sk.scoutbook.app.ui.screen.settings.data.item.ThemeItem
import sk.scoutbook.app.ui.theme.ThemeViewModel

class AppearanceCategory(
    themeViewModel: ThemeViewModel
): SettingsCategory(
    title = R.string.appearance_title,
    icon = R.drawable.palette_24px,
    subcategories = listOf(
        ThemeItem(themeViewModel),
        DynamicColorItem(themeViewModel),
        ContrastItem(themeViewModel)
    )
)