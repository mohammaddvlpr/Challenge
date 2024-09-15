package com.jabama.challenge.data.repository.search.dataSource.remote

import com.jabama.challenge.data.network.PAGE_SIZE
import com.jabama.challenge.data.network.search.SearchService
import com.jabama.challenge.data.repository.search.SearchMapper
import com.jabama.challenge.data.repository.search.paging.SearchPagingSource
import kotlinx.coroutines.flow.Flow

class SearchRemoteRemoteDataSourceImpl(
    private val searchService: SearchService,
    private val searchMapper: SearchMapper
) : SearchRemoteDataSource {
    override fun getSearchFlow(query: String): Flow<PagingData<SearchModel>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PAGE_SIZE),
            pagingSourceFactory = {
                SearchPagingSource(
                    query = query,
                    searchService = searchService,
                    searchMapper = searchMapper
                )
            }
        ).flow

    }
}