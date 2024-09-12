package com.jabama.challenge.repository.search.dataSource.remote

import androidx.paging.PagingData
import com.jabama.challenge.domain.usecase.search.model.SearchModel
import kotlinx.coroutines.flow.Flow

class SearchRemoteRemoteDataSourceImpl : SearchRemoteDataSource {
    override fun getSearchFlow(query: String): Flow<PagingData<SearchModel>> {
        TODO("Not yet implemented")
    }
}