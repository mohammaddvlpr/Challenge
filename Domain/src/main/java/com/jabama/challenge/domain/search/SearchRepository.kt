package com.jabama.challenge.domain.search

import androidx.paging.PagingData
import com.jabama.challenge.domain.search.models.SearchModel
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getSearchFlow(query: String): Flow<PagingData<SearchModel>>
}