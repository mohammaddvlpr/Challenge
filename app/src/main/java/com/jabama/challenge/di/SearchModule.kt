package com.jabama.challenge.di

import com.jabama.challenge.data.network.search.SearchService
import com.jabama.challenge.data.repository.search.SearchMapper
import com.jabama.challenge.data.repository.search.SearchRepositoryImpl
import com.jabama.challenge.data.repository.search.dataSource.remote.SearchRemoteDataSource
import com.jabama.challenge.data.repository.search.dataSource.remote.SearchRemoteRemoteDataSourceImpl
import com.jabama.challenge.domain.search.SearchRepository
import com.jabama.challenge.ui.search.model.SearchUiMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val searchModule = module {
    factory<SearchService> { get<Retrofit>(named(RETROFIT)).create(SearchService::class.java) }
    factory<SearchRemoteDataSource> { SearchRemoteRemoteDataSourceImpl(get(), get()) }
    factory<SearchUiMapper> { SearchUiMapper(get()) }
    factory<SearchMapper> { SearchMapper() }
    factory { SearchRepositoryImpl(get()) as SearchRepository }
}