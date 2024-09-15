package com.jabama.challenge.data.repository.search.dataSource.remote

import androidx.paging.PagingData
import com.jabama.challenge.domain.search.model.SearchModel
import kotlinx.coroutines.flow.Flow

interface SearchRemoteDataSource {

    fun getSearchFlow(query:String):Flow<PagingData<SearchModel>>
}