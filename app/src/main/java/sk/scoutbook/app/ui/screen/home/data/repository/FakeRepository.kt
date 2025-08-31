package sk.scoutbook.app.ui.screen.home.data.repository

import sk.scoutbook.app.ui.screen.home.data.model.ActivityBadgeItem
import sk.scoutbook.app.ui.screen.home.data.model.ChallengeItem
import javax.inject.Inject

class FakeRepository @Inject constructor() : Repository {
    override suspend fun getChallenges(): List<ChallengeItem> {
        // Simulate network call
//        delay(1000)
        return listOf(
            ChallengeItem(1, "Tri orlie perá", true),
            ChallengeItem(2, "Biely štít", false)
        )
    }

    override suspend fun getActivityBadges(): List<ActivityBadgeItem> {
        return listOf(
            ActivityBadgeItem(1, "Prvá pomoc", 10, 8),
            ActivityBadgeItem(1, "Zálesák", 7, 7),
        )
    }
}
