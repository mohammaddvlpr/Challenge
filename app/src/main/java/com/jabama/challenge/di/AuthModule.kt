package com.jabama.challenge.di

import com.jabama.challenge.data.network.auth.AuthService
import com.jabama.challenge.data.repository.auth.AuthMapper
import com.jabama.challenge.data.repository.auth.AuthRepositoryImpl
import com.jabama.challenge.domain.auth.AuthRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val authModule = module {
    factory<AuthMapper> { AuthMapper() }
    factory { get<Retrofit>(named(RETROFIT)).create(AuthService::class.java) }
    factory<AuthRepository> { AuthRepositoryImpl(get() , get()) }
}