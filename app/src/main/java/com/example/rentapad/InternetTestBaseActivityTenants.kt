package com.example.rentapad

import android.content.IntentFilter
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_secondpage.*
import kotlinx.android.synthetic.main.landlords.*
import kotlinx.android.synthetic.main.tenants.*
import kotlinx.android.synthetic.main.tenants.internetDown
import kotlinx.android.synthetic.main.tenants.loading


open class BaseActivity : AppCompatActivity(), BroadCastReceiver.ConnectivityReceiverListener {
    private var mSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(BroadCastReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }


    private fun testInteret(isConnected: Boolean) {


               //NO INTERNET
        if (isConnected) {
            Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show()
            /*val messageToUser = "You are offline now." //TODO
*/            internetDown.visibility=View.GONE
              loading.visibility=View.GONE



                //WEBVIEW SETTINGS

              
             





        } else {
            Toast.makeText(this, "Disconnected", Toast.LENGTH_LONG).show()


            internetDown.visibility=View.VISIBLE
            loading.visibility=View.GONE


           

        }


    }

    override fun onResume() {
        super.onResume()

        BroadCastReceiver.connectivityReceiverListener = this
    }

    /**
     * Callback will be called when there is change
     */
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        testInteret(isConnected)
        
    }
}