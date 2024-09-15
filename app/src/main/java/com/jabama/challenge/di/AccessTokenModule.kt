package com.jabama.challenge.di

import com.jabama.challenge.data.network.oauth.AccessTokenService
import com.jabama.challenge.data.repository.oauth.AccessTokenDataSource
import com.jabama.challenge.data.repository.oauth.AccessTokenDataSourceImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val accessTokenModule = module {
    factory { get<Retrofit>(named(RETROFIT)).create(AccessTokenService::class.java) }
    factory<AccessTokenDataSource> { AccessTokenDataSourceImpl(get()) }
}