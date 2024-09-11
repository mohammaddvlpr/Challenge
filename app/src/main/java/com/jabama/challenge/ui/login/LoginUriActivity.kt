package com.jabama.challenge.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jabama.challenge.github.R
import com.jabama.challenge.network.oauth.RequestAccessToken
import com.jabama.challenge.repository.oauth.AccessTokenDataSource
import com.jabama.challenge.repository.token.TokenRepository
import com.jabama.challenge.ui.main.CLIENT_ID
import com.jabama.challenge.ui.main.CLIENT_SECRET
import com.jabama.challenge.ui.main.REDIRECT_URI
import kotlinx.android.synthetic.main.login_uri_activity.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginUriActivity : AppCompatActivity() {
    private val tokenRepository: TokenRepository by inject()
    private val accessTokenDataSource: AccessTokenDataSource by inject()
    private val loginViewModel: LoginViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_uri_activity)
    }

    override fun onResume() {
        super.onResume()

        val intent = intent
        if (Intent.ACTION_VIEW == intent.action) {
            val uri = intent.data
            val code = uri?.getQueryParameter("code") ?: ""

            code.takeIf { it.isNotEmpty() }?.let { code ->
                val accessTokenJob = CoroutineScope(Dispatchers.IO).launch {
                    val response = accessTokenDataSource.accessToken(
                        RequestAccessToken(
                            CLIENT_ID,
                            CLIENT_SECRET,
                            code,
                            REDIRECT_URI,
                            "0"
                        )
                    ).await()

                    tokenRepository.saveToken(response.accessToken).await()
                }

                accessTokenJob.invokeOnCompletion {
                    CoroutineScope(Dispatchers.Main).launch {
                        token.text = tokenRepository.readToken().await()
                        this.cancel()
                        accessTokenJob.cancelAndJoin()
                    }
                }
            } ?: run { finish() }
        }


    }
}