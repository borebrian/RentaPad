package com.example.rentapad

import android.app.AlertDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.landlords.*
import kotlinx.android.synthetic.main.tenants.*


class Landlords : BaseActivity1() {

    lateinit var bt: Button
    lateinit var cd: internetTestt


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landlords)
        loadWeb("http://remolatitude-001-site1.dtempurl.com/administration_module/login_bs.aspx")

    }
    fun loadWeb(url:String) {

        //WEBVIEW SETTINGS
        if (webView112 != null) {
            val webSettings = webView112!!.settings
            webSettings!!.javaScriptEnabled = true
            webView112!!.webViewClient = WebViewClient()
            webView112!!.webChromeClient = WebChromeClient()
            webView112!!.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webView112!!.getSettings().setAppCacheEnabled(false);
            webView112!!.loadUrl(url)

            //WHEN THE PAGE STARTS TO LOAD PROGRESSBAR IS SET TO  VISSIBLE
            webView112!!.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    loadingg.visibility = View.VISIBLE
                    webView112.visibility = View.GONE
                    //NOW INTERNET IS AVAILLABLE LETS
                    super.onPageStarted(view, url, favicon)

                }

                //WHEN THE PAGE FINISH TO LOAD THE PROGRESSBAR IS SET TO INVISSIBLE
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    loadingg.visibility = View.GONE
                    webView112.visibility = View.VISIBLE
                    super.onPageFinished(view, url)
                    /*val profileName=intent.getStringExtra("barcodeResults")*/
                    /* view?.loadUrl("javascript:myJavaScriptFunc('Successful')")*/
                   /* webView112!!.loadUrl("javascript:myJavaScriptFunc('"+profileName+"')");*/
                    //if passing in an object. Mapping may need to take place

                }

            }
        }

    }
    //HOME BACK BUTTON 
    override fun onBackPressed() {
        if(webView112.canGoBack()){
            webView112.goBack()
        }

        else{
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_view, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
               
            //show dialog
            val  mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.stay.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()

            }
            //cancel button click of custom layout
            mDialogView.quit.setOnClickListener {
                //dismiss dialog
                this.finish();

            }
        }
    }
       
        }
