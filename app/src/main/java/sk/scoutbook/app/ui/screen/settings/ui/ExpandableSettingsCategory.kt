package sk.scoutbook.app.ui.screen.settings.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import sk.scoutbook.app.ui.screen.settings.data.category.SettingsCategory
import sk.scoutbook.app.ui.screen.settings.data.category.item.MultiChoiceItem
import sk.scoutbook.app.ui.screen.settings.data.category.item.ToggleItem

@Composable
fun ExpandableSettingsCategory(category: SettingsCategory, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium, // rounded corners
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(top = 12.dp, start = 12.dp, end = 8.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(category.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(28.dp)
                )
                Text(
                    text = stringResource(category.title),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(
                    modifier = Modifier.padding(start = 12.dp, bottom = 8.dp, end = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    category.subcategories.forEach { item ->
                        when (item) {
                            is MultiChoiceItem<*> -> SettingsMultiChoiceItem(item)
                            is ToggleItem -> SettingsToggleItem(
                                modifier = Modifier.padding(
                                    horizontal = 4.dp
                                ), item = item
                            )
                        }
                    }
                }
            }
        }
    }
}