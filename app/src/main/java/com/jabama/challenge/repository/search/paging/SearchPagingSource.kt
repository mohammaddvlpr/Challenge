package com.jabama.challenge.repository.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jabama.challenge.network.search.SearchService
import com.jabama.challenge.repository.apiCall

class SearchPagingSource(
    private val query: String,
    private val searchService: SearchService,
) : PagingSource<Int, Any>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Any> {
        val key = params.key ?: 0
        val result = apiCall { searchService.search(query = query) }

        TODO()
    }

    override fun getRefreshKey(state: PagingState<Int, Any>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}