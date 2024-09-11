package com.jabama.challenge.ui.login

import androidx.lifecycle.ViewModel
import com.jabama.challenge.network.oauth.RequestAccessToken
import com.jabama.challenge.repository.oauth.AccessTokenDataSource
import com.jabama.challenge.repository.token.TokenRepository
import com.jabama.challenge.ui.main.CLIENT_ID
import com.jabama.challenge.ui.main.CLIENT_SECRET
import com.jabama.challenge.ui.main.REDIRECT_URI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch

class LoginViewModel(
    private val tokenRepository: TokenRepository,
    private val accessTokenDataSource: AccessTokenDataSource
) : ViewModel() {
    fun onAuthorizationCodeReceived(code: String) {
        code.takeIf { it.isNotEmpty() }?.let {
            val accessTokenJob = CoroutineScope(Dispatchers.IO).launch {
                val response = accessTokenDataSource.accessToken(
                    RequestAccessToken(
                        CLIENT_ID,
                        CLIENT_SECRET,
                        it,
                        REDIRECT_URI,
                        "0"
                    )
                ).await()

                tokenRepository.saveToken(response.accessToken).await()
            }

            accessTokenJob.invokeOnCompletion {
                CoroutineScope(Dispatchers.Main).launch {
//                    token.text = tokenRepository.readToken().await()
                    this.cancel()
                    accessTokenJob.cancelAndJoin()
                }
            }
        }
    }
}