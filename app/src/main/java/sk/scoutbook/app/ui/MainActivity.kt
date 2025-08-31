package sk.scoutbook.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import sk.scoutbook.app.ui.navigation.BottomNavigationBar
import sk.scoutbook.app.ui.theme.LocalThemeViewModel
import sk.scoutbook.app.ui.theme.ScoutBookTheme
import sk.scoutbook.app.ui.theme.ThemeViewModel


@AndroidEntryPoint // for Hilt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val themeViewModel: ThemeViewModel = hiltViewModel()

            val systemTheme = isSystemInDarkTheme()
//            LaunchedEffect(Unit) {
//                themeViewModel.updateSystemTheme(systemDark)
//            }

//            val darkTheme by themeViewModel.isDarkThemeFlow.collectAsStateWithLifecycle()
            val selectedTheme by themeViewModel.selectedThemeOptionFlow.collectAsStateWithLifecycle()
            val darkTheme = selectedTheme.isDarkTheme ?: systemTheme
            val contrastMode by themeViewModel.contrastModeFlow.collectAsStateWithLifecycle()
            val dynamicColor by themeViewModel.dynamicColorFlow.collectAsStateWithLifecycle()

            CompositionLocalProvider(LocalThemeViewModel provides themeViewModel) {
                ScoutBookTheme(
                    darkTheme = darkTheme, contrastMode = contrastMode, dynamicColor = dynamicColor
                ) {
                    BottomNavigationBar() // handles navigation
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScoutBookTheme {
        BottomNavigationBar()
    }
}