package sk.scoutbook.app.ui.screen.settings.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import sk.scoutbook.app.ui.screen.settings.data.item.MultiChoiceItem
import sk.scoutbook.app.ui.screen.settings.data.item.options.SettingsMultiChoiceOption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SettingsMultiChoiceItem(
    item: MultiChoiceItem<T>, modifier: Modifier = Modifier
) where T : Enum<T>, T : SettingsMultiChoiceOption<T> {
    var expanded by remember { mutableStateOf(false) }
    val selectedOption by item.selectedOption.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = item.title),
            style = MaterialTheme.typography.titleMedium,
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = stringResource(selectedOption.title),
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryEditable, true)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.titleSmall,
                shape = RoundedCornerShape(16.dp),
            )

            ExposedDropdownMenu(
                expanded = expanded, onDismissRequest = { expanded = false }) {
                item.options.filter { it.title != selectedOption.title }.forEach { option ->
                    DropdownMenuItem(text = {
                        Text(
                            text = stringResource(option.title),
                            style = MaterialTheme.typography.titleSmall
                        )
                    }, onClick = {
                        item.action(option)
//                        item.selectedOption = option
                        expanded = false
                    })
                }
            }
        }
    }
}