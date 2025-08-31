package sk.scoutbook.app.ui.screen.home.data.repository

import sk.scoutbook.app.ui.screen.home.data.model.ActivityBadgeItem

interface ActivityBadgesRepository {
    suspend fun getActivityBadges(): List<ActivityBadgeItem>
}