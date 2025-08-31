package sk.scoutbook.app.ui.screen.home

import sk.scoutbook.app.ui.screen.home.data.model.ActivityBadgeItem
import sk.scoutbook.app.ui.screen.home.data.model.ChallengeItem

data class HomeUiState(
    val isLoading: Boolean = false,
    val challengeItems: List<ChallengeItem> = emptyList(),
    val activityBadgeItems: List<ActivityBadgeItem> = emptyList(),
    val error: String? = null
)