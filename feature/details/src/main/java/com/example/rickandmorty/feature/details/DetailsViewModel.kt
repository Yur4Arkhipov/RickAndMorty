package com.example.rickandmorty.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.usecase.GetCharacterByIdUseCase

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getCharacterById: GetCharacterByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Character>>(UiState.Loading)
    val uiState: StateFlow<UiState<Character>> = _uiState

    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val character = getCharacterById(id)
                _uiState.value = UiState.Success(character)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Ошибка загрузки")
            }
        }
    }
}
