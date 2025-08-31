package sk.scoutbook.app.ui.screen.calendar

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
class CalendarViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState.asStateFlow()

    init {
        loadTodos()
    }

    private fun loadTodos() {
        viewModelScope.launch {
            _uiState.value = CalendarUiState(isLoading = true)
            try {
                val items = repository.getChallenges()
                _uiState.value = CalendarUiState(items = items)
            } catch (e: Exception) {
                _uiState.value = CalendarUiState(error = e.message)
            }
        }
    }
}