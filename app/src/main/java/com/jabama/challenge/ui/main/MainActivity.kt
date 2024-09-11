package com.jabama.challenge.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jabama.challenge.github.R
import kotlinx.android.synthetic.main.activity_main.*

const val CLIENT_ID = "Ov23liNJmGQ53rBTtUCC"
const val CLIENT_SECRET = "bbb212a4078de9c927ec8cae049b85c15ad32fab"
const val REDIRECT_URI = "oauth://jabamatest.com"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        authorize.setOnClickListener { view ->
            val url = "https://github.com/login/oauth/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URI&scope=repo user&state=0"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}
