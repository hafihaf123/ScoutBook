package sk.scoutbook.app.ui.screen.settings.data.category

import sk.scoutbook.app.R
import sk.scoutbook.app.ui.screen.settings.data.category.item.ContrastItem
import sk.scoutbook.app.ui.screen.settings.data.category.item.DynamicColorItem
import sk.scoutbook.app.ui.screen.settings.data.category.item.ThemeItem
import sk.scoutbook.app.ui.theme.ThemeViewModel

class AppearanceCategory(
    themeViewModel: ThemeViewModel,
    systemTheme: Boolean
): SettingsCategory(
    title = R.string.appearance_title,
    icon = R.drawable.palette_24px,
    subcategories = listOf(
        ThemeItem(themeViewModel, systemTheme),
        DynamicColorItem(themeViewModel),
        ContrastItem(themeViewModel)
    )
)