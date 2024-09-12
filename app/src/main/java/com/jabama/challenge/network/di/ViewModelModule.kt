package com.jabama.challenge.network.di

import com.jabama.challenge.ui.login.LoginViewModel
import com.jabama.challenge.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { MainViewModel() }
}