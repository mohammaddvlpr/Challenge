package com.jabama.challenge.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jabama.challenge.domain.usecase.login.GetAccessTokenUseCase
import com.jabama.challenge.github.R

class LoginViewModel(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : ViewModel() {
    private val _description = MutableLiveData(0)
    val description: LiveData<Int> = _description

    private val _showProgress = MutableLiveData(false)
    val showProgress: LiveData<Boolean> = _showProgress

    fun onAuthorizationCodeReceived(code: String?) {
        code.takeIf { !it.isNullOrEmpty() }?.let {

//            todo: use viewModelScope
//            getAccessTokenUseCase(it)

            _description.value = R.string.authorization_code_received_message
            _showProgress.value = true

        }
    }

}