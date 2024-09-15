package com.jabama.challenge.di

import com.jabama.challenge.domain.usecase.accessToken.GetIsLoginUseCase
import com.jabama.challenge.domain.usecase.login.GetAccessTokenUseCase
import com.jabama.challenge.domain.usecase.search.GetSearchFlowUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAccessTokenUseCase> { GetAccessTokenUseCase(get(), get()) }
    factory<GetIsLoginUseCase> { GetIsLoginUseCase(get()) }
    factory<GetSearchFlowUseCase> { GetSearchFlowUseCase(get()) }
}