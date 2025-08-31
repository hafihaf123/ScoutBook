package sk.scoutbook.app.ui.screen.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import sk.scoutbook.app.ui.screen.settings.ui.ExpandableSettingsCategory
import sk.scoutbook.app.ui.theme.LocalThemeViewModel
import sk.scoutbook.app.ui.theme.ScoutBookTheme
import sk.scoutbook.app.ui.theme.ThemeViewModel

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val themeViewModel: ThemeViewModel = LocalThemeViewModel.current
    val systemTheme = isSystemInDarkTheme()

    LaunchedEffect(systemTheme) {
        viewModel.loadSettings(themeViewModel, systemTheme)
    }

    val uiState by viewModel.uiState.collectAsState()
    val categories = uiState.categories

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
    ) {
        Row {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 18.dp, end = 16.dp)
                    .size(40.dp)
            )
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }

        categories.forEach { category ->
            ExpandableSettingsCategory(category)
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    ScoutBookTheme {
        SettingsScreen()
    }
}