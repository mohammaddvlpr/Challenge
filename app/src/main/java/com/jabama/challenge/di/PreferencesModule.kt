package com.jabama.challenge.di

import com.jabama.challenge.data.repository.prefrences.PreferencesRepositoryImpl
import com.jabama.challenge.domain.accessToken.PreferencesRepository
import org.koin.dsl.module

val preferencesModule = module {
    single { PreferencesRepositoryImpl(get()) as PreferencesRepository }
}