package com.jabama.challenge.network.di

import com.jabama.challenge.network.search.SearchService
import com.jabama.challenge.repository.search.SearchMapper
import com.jabama.challenge.repository.search.dataSource.remote.SearchRemoteDataSource
import com.jabama.challenge.repository.search.dataSource.remote.SearchRemoteRemoteDataSourceImpl
import com.jabama.challenge.ui.search.model.UiMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val searchModule = module {
    factory<SearchService> { get<Retrofit>(named(RETROFIT)).create(SearchService::class.java) }
    factory<SearchRemoteDataSource> { SearchRemoteRemoteDataSourceImpl(get(), get()) }
    factory<UiMapper> { UiMapper(get()) }
    factory<SearchMapper> { SearchMapper() }

}