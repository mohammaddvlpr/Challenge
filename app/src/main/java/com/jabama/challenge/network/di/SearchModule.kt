package com.jabama.challenge.network.di

import com.jabama.challenge.network.search.SearchService
import com.jabama.challenge.repository.search.dataSource.remote.SearchRemoteDataSource
import com.jabama.challenge.repository.search.dataSource.remote.SearchRemoteRemoteDataSourceImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val searchModule = module {
    factory {
        factory { get<Retrofit>(named(RETROFIT)).create(SearchService::class.java) }
        factory<SearchRemoteDataSource> { SearchRemoteRemoteDataSourceImpl(get()) }
    }
}