package com.example.rickandmorty.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.core.domain.model.Character
import com.example.rickandmorty.core.domain.usecase.GetCharactersPagedUseCase
import com.example.rickandmorty.core.domain.usecase.GetCharactersPagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val getCharacters: GetPagedCharactersUseCase,
    private val getCharactersPagedUseCase: GetCharactersPagedUseCase,
    private val getCharactersPaging: GetCharactersPagingUseCase
): ViewModel() {
//    val charactersPagingFlow: Flow<PagingData<Character>> =
//        getCharacters().cachedIn(viewModelScope)

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _filterState = MutableStateFlow(FilterState())
    val filterState: StateFlow<FilterState> = _filterState


    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setFilter(status: String?, gender: String?) {
        _filterState.value = _filterState.value.copy(
            status = status,
            gender = gender
        )
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val characters: Flow<PagingData<Character>> = combine(
        _searchQuery.debounce(300).distinctUntilChanged(),
        _filterState
    ) { search, filter ->
        FilterState(
            name = search,
            status = filter.status,
            gender = filter.gender
        )
    }.flatMapLatest { filter ->
        getCharactersPaging(filter.name, filter.status, filter.gender)
    }.cachedIn(viewModelScope)

    fun clearFilters() {
        _filterState.value = FilterState(name = _searchQuery.value)
    }

}

data class FilterState(
    val name: String = "",
    val status: String? = null,
    val gender: String? = null
)