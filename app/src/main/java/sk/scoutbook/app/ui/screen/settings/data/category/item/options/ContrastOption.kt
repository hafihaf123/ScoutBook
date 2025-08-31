package sk.scoutbook.app.ui.screen.settings.data.category.item.options

import sk.scoutbook.app.R
import sk.scoutbook.app.ui.theme.ContrastMode
import sk.scoutbook.app.ui.theme.ThemeViewModel

enum class ContrastOption(val contrastMode: ContrastMode) :
    SettingsMultiChoiceOption<ContrastOption> {
    STANDARD_CONTRAST(contrastMode = ContrastMode.STANDARD) {
        override val title = R.string.standard_contrast
    },
    MEDIUM_CONTRAST(contrastMode = ContrastMode.MEDIUM) {
        override val title = R.string.medium_contrast
    },
    HIGH_CONTRAST(contrastMode = ContrastMode.HIGH) {
        override val title = R.string.high_contrast
    };

    fun perform(themeViewModel: ThemeViewModel) {
        themeViewModel.setContrastMode(contrastMode)
    }

    companion object {
        fun fromContrastMode(contrastMode: ContrastMode): ContrastOption =
            entries.firstOrNull { it.contrastMode == contrastMode } ?: STANDARD_CONTRAST
    }
}