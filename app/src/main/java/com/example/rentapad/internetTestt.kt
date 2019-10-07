package com.example.rentapad

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo




    @Suppress("DEPRECATION")
    class internetTestt {


        fun isConnectingToInternet(context: Context): Boolean {
            val connectivity = context.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivity != null) {
                val info = connectivity.allNetworkInfo
                if (info != null)
                    for (i in info)
                        if (i.state == NetworkInfo.State.CONNECTED) {
                            return true
                        }
            }
            return false
        }
    }
