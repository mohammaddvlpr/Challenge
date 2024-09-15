package com.jabama.challenge.domain.search.useCase

import androidx.paging.PagingData
import com.jabama.challenge.domain.search.SearchRepository
import com.jabama.challenge.domain.search.models.SearchModel
import kotlinx.coroutines.flow.Flow

class GetSearchFlowUseCase(private val searchRepository: SearchRepository) {

    operator fun invoke(query: String): Flow<PagingData<SearchModel>> {
        return searchRepository.getSearchFlow(query = query)
    }

}