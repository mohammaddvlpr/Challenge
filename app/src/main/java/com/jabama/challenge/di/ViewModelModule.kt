package com.jabama.challenge.di

import com.jabama.challenge.ui.login.LoginViewModel
import com.jabama.challenge.ui.main.MainViewModel
import com.jabama.challenge.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { SearchViewModel(get(), get()) }
}