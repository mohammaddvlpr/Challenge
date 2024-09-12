package com.jabama.challenge.repository.search.dataSource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jabama.challenge.domain.usecase.search.model.SearchModel
import com.jabama.challenge.network.search.SearchService
import com.jabama.challenge.repository.search.paging.SearchPagingSource
import kotlinx.coroutines.flow.Flow

class SearchRemoteRemoteDataSourceImpl(private val searchService: SearchService) : SearchRemoteDataSource {
    override fun getSearchFlow(query: String): Flow<PagingData<SearchModel>> {
        return Pager(
            config = PagingConfig(pageSize = 15, prefetchDistance = 2),
            pagingSourceFactory = {
                SearchPagingSource(query = query , searchService = searchService)
            }
        ).flow

    }
}