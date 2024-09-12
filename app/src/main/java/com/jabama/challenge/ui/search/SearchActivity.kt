package com.jabama.challenge.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jabama.challenge.login.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        initViews()
        observe()


    }

    private fun initViews() {
    }

    private fun observe() {

    }
}
