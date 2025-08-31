package sk.scoutbook.app.ui.screen.settings.data.category

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import sk.scoutbook.app.ui.screen.settings.data.category.item.SettingsItem

open class SettingsCategory(
    @param:StringRes val title: Int,
    @param:DrawableRes val icon: Int,
    val subcategories: List<SettingsItem>
)