package com.jabama.challenge.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jabama.challenge.github.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginUriActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModel()
    private lateinit var description: TextView
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_uri_activity)

        initViews()
        observe()
    }

    private fun observe() {
        loginViewModel.description.observe(this) {}
        loginViewModel.showProgress.observe(this) {}
    }

    private fun initViews() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()

        handleAuthorizationCode(intent)

    }

    private fun handleAuthorizationCode(intent: Intent?) {
        if (Intent.ACTION_VIEW == intent?.action) {
            val uri = intent.data
            val code = uri?.getQueryParameter("code") ?: ""

            loginViewModel.onAuthorizationCodeReceived(code)

        }
    }
}