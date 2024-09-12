package com.jabama.challenge.repository.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getSearchFlow(query: String): Flow<PagingData<Any>>
}