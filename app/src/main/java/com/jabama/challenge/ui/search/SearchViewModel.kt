package com.jabama.challenge.ui.search

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.jabama.challenge.domain.usecase.search.GetSearchFlowUseCase
import com.jabama.challenge.ui.search.model.SearchScreenState
import com.jabama.challenge.ui.search.model.UiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlin.time.Duration.Companion.milliseconds

class SearchViewModel(
    private val getSearchFlowUseCase: GetSearchFlowUseCase,
    private val uiMapper: UiMapper
) : ViewModel() {
    fun onQueryChange(query: String) {
        _state.update { it.copy(query = query) }
    }

    private val _state =
        MutableStateFlow(
            SearchScreenState(query = "")
        )

    val state: StateFlow<SearchScreenState> = _state.asStateFlow()


    val pagingFlow = _state.debounce(100.milliseconds).flatMapLatest {
        getSearchFlowUseCase(it.query).map { pagingData ->
            pagingData.map { searchModel ->
                uiMapper.mapToUi(
                    searchModel
                )
            }
        }
    }

}