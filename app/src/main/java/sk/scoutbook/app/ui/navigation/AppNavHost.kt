package sk.scoutbook.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sk.scoutbook.app.ui.screen.calendar.CalendarScreen
import sk.scoutbook.app.ui.screen.home.HomeScreen
import sk.scoutbook.app.ui.screen.settings.SettingsScreen

@Composable
fun AppNavHost(
    navController: NavHostController, startDestination: Destination, modifier: Modifier = Modifier
) {
    NavHost(
        navController, startDestination = startDestination.route, modifier = modifier
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.HOME -> HomeScreen()
                    Destination.CALENDAR -> CalendarScreen()
                    Destination.Settings -> SettingsScreen()
                }
            }
        }
    }
}