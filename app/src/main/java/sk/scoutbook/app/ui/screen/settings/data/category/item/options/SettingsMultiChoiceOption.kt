package sk.scoutbook.app.ui.screen.settings.data.category.item.options

interface SettingsMultiChoiceOption<T> where T : Enum<T> {
    val title: Int
}