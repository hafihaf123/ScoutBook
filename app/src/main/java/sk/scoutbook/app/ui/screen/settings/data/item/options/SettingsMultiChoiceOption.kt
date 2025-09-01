package sk.scoutbook.app.ui.screen.settings.data.item.options

interface SettingsMultiChoiceOption<T> where T : Enum<T> {
    val title: Int
}