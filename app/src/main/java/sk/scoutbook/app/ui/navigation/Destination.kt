package sk.scoutbook.app.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import sk.scoutbook.app.R

enum class Destination(
    val route: String,
    @param:StringRes val title: Int,
    @param:StringRes val contentDescription: Int,
    val icon: ImageVector,
) {
    HOME(
        route = "home",
        title = R.string.home,
        contentDescription = R.string.home_descr,
        icon = Icons.Outlined.Home,
    ),
    CALENDAR(
        route = "calendar",
        title = R.string.calendar,
        contentDescription = R.string.calendar_descr,
        icon = Icons.Outlined.DateRange,
    ),
    Settings(
        route = "settings",
        title = R.string.settings,
        contentDescription = R.string.settings_descr,
        icon = Icons.Outlined.Settings
    )
}