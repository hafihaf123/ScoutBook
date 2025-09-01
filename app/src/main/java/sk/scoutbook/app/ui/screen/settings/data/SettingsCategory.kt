package sk.scoutbook.app.ui.screen.settings.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import sk.scoutbook.app.ui.screen.settings.data.item.SettingsItem

open class SettingsCategory(
    @param:StringRes val title: Int,
    @param:DrawableRes val icon: Int,
    val subcategories: List<SettingsItem>
)