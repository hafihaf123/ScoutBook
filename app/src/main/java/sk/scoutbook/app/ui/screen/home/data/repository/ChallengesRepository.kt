package sk.scoutbook.app.ui.screen.home.data.repository

import sk.scoutbook.app.ui.screen.home.data.model.ChallengeItem

interface ChallengesRepository {
    suspend fun getChallenges(): List<ChallengeItem>
}