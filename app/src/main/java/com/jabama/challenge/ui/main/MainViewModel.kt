package com.jabama.challenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jabama.challenge.domain.usecase.accessToken.GetIsLoginUseCase
import com.jabama.challenge.login.R
import kotlinx.coroutines.launch

class MainViewModel(private val getIsLoginUseCase: GetIsLoginUseCase) : ViewModel() {

    private val _description = MutableLiveData(0)
    val description: LiveData<Int> = _description

    init {
        viewModelScope.launch {
            val isLogin = getIsLoginUseCase()

            if (isLogin)
                _description.value = R.string.already_login_message
            else
                _description.value = R.string.start_message

        }
    }

}