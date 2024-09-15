package com.jabama.challenge.ui.search

import androidx.lifecycle.ViewModel
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.map
import com.jabama.challenge.domain.search.useCase.GetSearchFlowUseCase
import com.jabama.challenge.ui.search.model.SearchScreenState
import com.jabama.challenge.ui.search.model.SearchUiMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlin.time.Duration.Companion.milliseconds

class SearchViewModel(
    private val getSearchFlowUseCase: GetSearchFlowUseCase,
    private val searchUiMapper: SearchUiMapper
) : ViewModel() {
    fun onQueryChange(query: String) {
        _state.update { it.copy(query = query) }
    }

    private val _state =
        MutableStateFlow(
            SearchScreenState(query = "")
        )

    val state: StateFlow<SearchScreenState> = _state.asStateFlow()


    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val pagingFlow = _state.debounce(100.milliseconds).flatMapLatest {
        if (it.query.isNotEmpty())
            getSearchFlowUseCase(it.query).map { pagingData ->
                pagingData.map { searchModel ->
                    searchUiMapper.mapToUi(
                        searchModel
                    )
                }
            }
        else
            flow {
                emit(
                    PagingData.empty(
                        sourceLoadStates = LoadStates(
                            refresh = LoadState.NotLoading(
                                false
                            ),
                            append = LoadState.NotLoading(false),
                            prepend = LoadState.NotLoading(false)
                        )
                    )
                )
            }
    }

}