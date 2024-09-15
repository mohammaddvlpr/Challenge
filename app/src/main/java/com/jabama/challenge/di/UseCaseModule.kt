package com.jabama.challenge.di

import com.jabama.challenge.domain.preferences.useCase.GetIsLoginUseCase
import com.jabama.challenge.domain.auth.useCase.GetAccessTokenUseCase
import com.jabama.challenge.domain.auth.useCase.GetAuthorizationUrlUseCase
import com.jabama.challenge.domain.search.useCase.GetSearchFlowUseCase
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

    factory<GetAuthorizationUrlUseCase> {
        GetAuthorizationUrlUseCase(
            get()
        )
    }

}