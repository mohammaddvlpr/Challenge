package com.jabama.challenge.repository.search.dataSource.remote

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class SearchRemoteRemoteDataSourceImpl : SearchRemoteDataSource {
    override fun getSearchFlow(query: String): Flow<PagingData<Any>> {
        TODO("Not yet implemented")
    }
}