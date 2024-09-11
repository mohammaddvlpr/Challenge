package com.jabama.challenge.network.di

import com.jabama.challenge.domain.usecase.login.GetAccessTokenUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAccessTokenUseCase> { GetAccessTokenUseCase(get(), get()) }
}