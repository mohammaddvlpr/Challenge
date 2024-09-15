package com.jabama.challenge.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jabama.challenge.login.R
import com.jabama.challenge.ui.search.SearchActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


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
            mainViewModel.onAuthorizeClick()
        }

        description = findViewById(R.id.description)
        search = findViewById(R.id.search)


        search.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
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
        
        mainViewModel.openUri.observe(this){

            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(it)
            startActivity(i)

        }
    }
}
