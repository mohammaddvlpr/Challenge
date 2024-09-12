package com.jabama.challenge.domain.usecase.search

import androidx.paging.PagingData
import com.jabama.challenge.domain.usecase.search.model.SearchModel
import com.jabama.challenge.repository.search.SearchRepository
import kotlinx.coroutines.flow.Flow

class GetSearchFlowUseCase(private val searchRepository: SearchRepository) {

    suspend operator fun invoke(query: String): Flow<PagingData<SearchModel>> {
        return searchRepository.getSearchFlow(query = query)
    }

}