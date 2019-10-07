package com.example.rentapad

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.menu.*

class Lanlords_with_bottom_menu  : AppCompatActivity() {
    private val   mOnNavigationItemSelectedListener =BottomNavigationView.OnNavigationItemSelectedListener {item->

         when(item.itemId ){
             R.id.home -> {
                println("Home pressed")
                 return@OnNavigationItemSelectedListener true
             }
             R.id.map -> {
                 println("Home pressed")
                 return@OnNavigationItemSelectedListener true

             }
             R.id.booking -> {
                 println("Home pressed")
                 return@OnNavigationItemSelectedListener true

             }
         }
        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        bottomNav.setOnNavigationItemReselectedListener {

            
        }

    } }