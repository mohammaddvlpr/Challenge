package com.jabama.challenge.di

import com.jabama.challenge.data.repository.oauth.AuthMapper
import org.koin.dsl.module

val authModule = module {
    factory<AuthMapper> { AuthMapper() }

}