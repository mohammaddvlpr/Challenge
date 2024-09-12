package com.jabama.challenge.ui.search

import androidx.lifecycle.ViewModel
import com.jabama.challenge.ui.search.model.SearchScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel() : ViewModel() {

    private val _state = MutableStateFlow(SearchScreenState(query = ""))
    val state: StateFlow<SearchScreenState> = _state.asStateFlow()

}