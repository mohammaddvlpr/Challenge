package com.jabama.challenge.repository.search

import androidx.paging.PagingData
import com.jabama.challenge.domain.usecase.search.model.SearchModel
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getSearchFlow(query: String): Flow<PagingData<SearchModel>>
}