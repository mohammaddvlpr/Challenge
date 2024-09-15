package com.jabama.challenge.data.repository.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jabama.challenge.data.network.PAGE_SIZE
import com.jabama.challenge.data.network.search.SearchRepositoryModel
import com.jabama.challenge.data.network.search.SearchService
import com.jabama.challenge.data.repository.apiCall
import com.jabama.challenge.data.repository.search.SearchMapper

class SearchPagingSource(
    private val query: String,
    private val searchService: SearchService,
    private val searchMapper: SearchMapper,
) : PagingSource<Int, SearchModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchModel> {
        val key = params.key ?: 0
        val result = apiCall { searchService.search(query = query) }

        return if (result.isSuccess) {
            val model = result.getOrDefault(SearchRepositoryModel(listOf()))
            LoadResult.Page(
                data = searchMapper.mapToDomain(model.items),
                prevKey = null,
                nextKey = if (model.items.size < PAGE_SIZE) null else key + 1
            )

        } else
            LoadResult.Error(
                result.exceptionOrNull() ?: Exception("ProductPagingSource: Error not known")
            )
    }

    override fun getRefreshKey(state: PagingState<Int, SearchModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}