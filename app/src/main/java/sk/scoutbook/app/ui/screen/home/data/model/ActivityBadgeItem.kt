package sk.scoutbook.app.ui.screen.home.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ActivityBadgeItem(
    val id: Int,
    val title: String,
    val points: Int,
    var progress: Int,
    val icon: ImageVector? = null
)
