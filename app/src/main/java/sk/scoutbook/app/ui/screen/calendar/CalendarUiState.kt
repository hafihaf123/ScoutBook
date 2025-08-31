package sk.scoutbook.app.ui.screen.calendar

import sk.scoutbook.app.ui.screen.home.data.model.ChallengeItem

data class CalendarUiState(
    val isLoading: Boolean = false,
    val items: List<ChallengeItem> = emptyList(),
    val error: String? = null
)