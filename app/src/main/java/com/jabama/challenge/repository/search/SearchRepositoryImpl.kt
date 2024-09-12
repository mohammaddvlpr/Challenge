package com.jabama.challenge.repository.search

import androidx.paging.PagingData
import com.jabama.challenge.domain.usecase.search.model.SearchModel
import com.jabama.challenge.repository.search.dataSource.remote.SearchRemoteDataSource
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(private val remoteDataSource: SearchRemoteDataSource) :
    SearchRepository {
    override fun getSearchFlow(query: String): Flow<PagingData<SearchModel>> {
        return remoteDataSource.getSearchFlow(query)
    }
}