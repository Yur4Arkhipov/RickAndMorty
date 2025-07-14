package com.example.rickandmorty.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.usecase.GetPagedCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharacters: GetPagedCharactersUseCase
): ViewModel() {
    val charactersPagingFlow: Flow<PagingData<Character>> =
        getCharacters().cachedIn(viewModelScope)

}