package com.jabama.challenge.data.repository.search

import com.jabama.challenge.data.repository.search.dataSource.remote.SearchRemoteDataSource
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(private val remoteDataSource: SearchRemoteDataSource) :
    SearchRepository {
    override fun getSearchFlow(query: String): Flow<PagingData<SearchModel>> {
        return remoteDataSource.getSearchFlow(query)
    }
}