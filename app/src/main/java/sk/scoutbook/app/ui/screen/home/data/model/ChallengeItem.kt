package sk.scoutbook.app.ui.screen.home.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ChallengeItem(
    val id: Int,
    val title: String,
    val done: Boolean,
    val icon: ImageVector? = null
)