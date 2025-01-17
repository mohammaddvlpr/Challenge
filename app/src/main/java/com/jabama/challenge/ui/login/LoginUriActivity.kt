package com.jabama.challenge.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jabama.challenge.login.R
import com.jabama.challenge.ui.search.SearchActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginUriActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModel()
    private lateinit var description: TextView
    private lateinit var progress: ProgressBar
    private lateinit var search: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_uri_activity)

        initViews()
        observe()
    }

    private fun observe() {
        loginViewModel.description.observe(this) {
            description.text = getString(it)
        }
        loginViewModel.showProgress.observe(this) {
            progress.isVisible = it
        }

        loginViewModel.showSearch.observe(this) {
            search.isVisible = it
        }
    }

    private fun initViews() {
        description = findViewById(R.id.description)
        progress = findViewById(R.id.progress)
        search = findViewById(R.id.search)

        search.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        handleAuthorizationCode(intent)

    }

    private fun handleAuthorizationCode(intent: Intent?) {
        if (Intent.ACTION_VIEW == intent?.action) {
            val uri = intent.data
            val code = uri?.getQueryParameter("code")

            loginViewModel.onAuthorizationCodeReceived(code)

        }
    }
}