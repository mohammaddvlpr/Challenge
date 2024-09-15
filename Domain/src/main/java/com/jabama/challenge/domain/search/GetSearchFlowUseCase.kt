package com.jabama.challenge.domain.search

import androidx.paging.PagingData
import com.jabama.challenge.data.repository.search.SearchRepository
import com.jabama.challenge.domain.search.model.SearchModel
import kotlinx.coroutines.flow.Flow

class GetSearchFlowUseCase(private val searchRepository: SearchRepository) {

    suspend operator fun invoke(query: String): Flow<PagingData<SearchModel>> {
        return searchRepository.getSearchFlow(query = query)
    }

}