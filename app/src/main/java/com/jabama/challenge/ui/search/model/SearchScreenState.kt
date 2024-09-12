package com.jabama.challenge.ui.search.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

data class SearchScreenState(
    val query: String,
    val pagingFlow: Flow<PagingData<SearchUiModel>>
)
