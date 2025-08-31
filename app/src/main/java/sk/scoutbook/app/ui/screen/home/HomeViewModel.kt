package sk.scoutbook.app.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sk.scoutbook.app.ui.screen.home.data.repository.Repository

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            _uiState.value = HomeUiState(isLoading = true)
            try {
                val challengeItems = repository.getChallenges()
                val activityBadgeItems = repository.getActivityBadges()
                _uiState.value = HomeUiState(
                    challengeItems = challengeItems, activityBadgeItems = activityBadgeItems
                )
            } catch (e: Exception) {
                _uiState.value = HomeUiState(error = e.message)
            }
        }
    }
}