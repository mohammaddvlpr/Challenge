package com.jabama.challenge.ui.search

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.jabama.challenge.domain.usecase.search.GetSearchFlowUseCase
import com.jabama.challenge.ui.search.model.SearchScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

class SearchViewModel(private val getSearchFlowUseCase: GetSearchFlowUseCase) : ViewModel() {

    private val _state =
        MutableStateFlow(
            SearchScreenState(query = "",
                flow { emit(PagingData.empty()) })
        )
    val state: StateFlow<SearchScreenState> = _state.asStateFlow()


}