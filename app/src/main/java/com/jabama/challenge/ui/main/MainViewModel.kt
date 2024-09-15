package com.jabama.challenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jabama.challenge.domain.accessToken.GetIsLoginUseCase
import com.jabama.challenge.domain.login.GetAuthorizationUrlUseCase
import com.jabama.challenge.login.R
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getIsLoginUseCase: GetIsLoginUseCase,
    private val getAuthorizationUrlUseCase: GetAuthorizationUrlUseCase
) : ViewModel() {
    private val _description = MutableLiveData(0)
    val description: LiveData<Int> = _description

    private val _showSearch = MutableLiveData(false)
    val showSearch: LiveData<Boolean> = _showSearch

    private val _openUri : MutableSharedFlow<String> = MutableSharedFlow()
    val openUri: SharedFlow<String> = _openUri.asSharedFlow()

    init {
        viewModelScope.launch {
            val isLogin = getIsLoginUseCase()
            _showSearch.value = isLogin

            if (isLogin) _description.value =
                R.string.already_login_message
            else
                _description.value = R.string.start_message

        }
    }

    fun onAuthorizeClick() {
        viewModelScope.launch {
            _openUri.emit(getAuthorizationUrlUseCase())
        }
    }

}