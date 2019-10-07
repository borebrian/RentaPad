package com.example.rentapad

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_secondpage.*

class MainActivity : AppCompatActivity() {

    lateinit var bt: Button
    lateinit var cd: internetTestt


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)


        Handler().postDelayed({
            //doSomethingHere()
            var intent = Intent(baseContext, Log_in_type::class.java)
            startActivity(intent)
            finish()

        }, 5000)


    }}





                // Display a negative button on alert dialog
