package com.jabama.challenge.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jabama.challenge.domain.login.GetAccessTokenUseCase
import com.jabama.challenge.login.R
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : ViewModel() {
    private val _description = MutableLiveData(R.string.please_wait)
    val description: LiveData<Int> = _description

    private val _showProgress = MutableLiveData(false)
    val showProgress: LiveData<Boolean> = _showProgress

    private val _showSearch = MutableLiveData(false)
    val showSearch: LiveData<Boolean> = _showSearch

    fun onAuthorizationCodeReceived(code: String?) {
        code.takeIf { !it.isNullOrEmpty() }?.let {
            _description.value = R.string.authorization_code_received_message
            _showProgress.value = true

            viewModelScope.launch {
                val result = getAccessTokenUseCase(it)
                if (result) {
                    _description.value = R.string.access_token_received_message
                    _showProgress.value = false
                    _showSearch.value = true
                }

            }

        }
    }

}