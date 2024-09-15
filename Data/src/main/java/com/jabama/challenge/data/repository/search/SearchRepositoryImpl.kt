package com.jabama.challenge.data.repository.search

import androidx.paging.PagingData
import com.jabama.challenge.data.repository.search.dataSource.remote.SearchRemoteDataSource
import com.jabama.challenge.domain.search.SearchRepository
import com.jabama.challenge.domain.search.model.SearchModel
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(private val remoteDataSource: SearchRemoteDataSource) :
    SearchRepository {
    override fun getSearchFlow(query: String): Flow<PagingData<SearchModel>> {
        return remoteDataSource.getSearchFlow(query)
    }
}