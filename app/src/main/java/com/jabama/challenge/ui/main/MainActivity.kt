package com.jabama.challenge.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jabama.challenge.login.R
import org.koin.androidx.viewmodel.ext.android.viewModel

const val CLIENT_ID = "Ov23liNJmGQ53rBTtUCC"
const val CLIENT_SECRET = "bbb212a4078de9c927ec8cae049b85c15ad32fab"
const val REDIRECT_URI = "oauth://jabamatest.com"

class MainActivity : AppCompatActivity() {
    private lateinit var authorize: Button
    private lateinit var search: Button
    private lateinit var description: TextView
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        observe()


    }

    private fun initViews() {
        authorize = findViewById(R.id.authorize)
        authorize.setOnClickListener {
            val url =
                "https://github.com/login/oauth/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=repo user&state=0"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        description = findViewById(R.id.description)
        search = findViewById(R.id.search)


        search.setOnClickListener {

        }
    }

    private fun observe() {
        mainViewModel.description.observe(this) {
            if (it > 0)
                description.text = getString(it)
        }

        mainViewModel.showSearch.observe(this) {
            search.isVisible = it
        }
    }
}
