package com.jabama.challenge.di

import com.jabama.challenge.domain.accessToken.GetIsLoginUseCase
import com.jabama.challenge.domain.login.GetAccessTokenUseCase
import com.jabama.challenge.domain.search.GetSearchFlowUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAccessTokenUseCase> {
        GetAccessTokenUseCase(
            get(),
            get()
        )
    }
    factory<GetIsLoginUseCase> {
        GetIsLoginUseCase(
            get()
        )
    }
    factory<GetSearchFlowUseCase> {
        GetSearchFlowUseCase(
            get()
        )
    }
}