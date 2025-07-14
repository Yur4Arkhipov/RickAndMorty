package com.example.rickandmorty.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.usecase.GetCharactersPagedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val getCharacters: GetPagedCharactersUseCase,
    private val getCharactersPagedUseCase: GetCharactersPagedUseCase
): ViewModel() {
//    val charactersPagingFlow: Flow<PagingData<Character>> =
//        getCharacters().cachedIn(viewModelScope)

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val characters: Flow<PagingData<Character>> = searchQuery
        .debounce(300)
        .distinctUntilChanged()
        .flatMapLatest { query ->
            getCharactersPagedUseCase(query)
        }
        .cachedIn(viewModelScope)
}