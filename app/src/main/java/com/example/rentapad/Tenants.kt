package com.example.rentapad

import android.app.DownloadManager
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_secondpage.*
import kotlinx.android.synthetic.main.tenants.*

class Tenants : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tenants)


        //LETS CHECK IF THEIR IS SCANNED VALUE FROM QR CODE
        val profileName=intent.getStringExtra("barcodeResults")
        if(profileName !=null){
               //TO MEAN THERE WAS A VALUE FROM QR CODE
            loadWeb("http://remolatitude-001-site1.dtempurl.com/administration_module/login_bs.aspx")




        }
        else{
            //ELSE LETS LOAD THE LOGIN PORTAL
            loadWeb("http://remolatitude-001-site1.dtempurl.com/administration_module/login_bs.aspx")
        }






    /*    webviewShow.visibility=View.GONE
        loading.visibility=View.GONE
        internetDown.visibility=View.GONE*/

       
}
    //FUNCTION FOR LOADING THE SITE TO THE WEBVIEW
   fun loadWeb(url:String) {

        //WEBVIEW SETTINGS
        if (webView1 != null) {
            val webSettings = webView1!!.settings
            webSettings!!.javaScriptEnabled = true
            webView1!!.webViewClient = WebViewClient()
            webView1!!.webChromeClient = WebChromeClient()
            webView1!!.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webView1!!.getSettings().setAppCacheEnabled(false);
            webView1!!.loadUrl(url)

            //WHEN THE PAGE STARTS TO LOAD PROGRESSBAR IS SET TO  VISSIBLE
            webView1!!.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    loading.visibility = View.VISIBLE
                    webView1.visibility = View.GONE
                    //NOW INTERNET IS AVAILLABLE LETS
                    super.onPageStarted(view, url, favicon)

                }

                //WHEN THE PAGE FINISH TO LOAD THE PROGRESSBAR IS SET TO INVISSIBLE
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    loading.visibility = View.GONE
                    webView1.visibility = View.VISIBLE
                    super.onPageFinished(view, url)
                    val profileName=intent.getStringExtra("barcodeResults")
                   /* view?.loadUrl("javascript:myJavaScriptFunc('Successful')")*/
                    webView1!!.loadUrl("javascript:myJavaScriptFunc('"+profileName+"')");
                    //if passing in an object. Mapping may need to take place

                }

            }
        }

        }
//HOME BACK BUTTON 
    override fun onBackPressed() {
        if(webView1.canGoBack()){
          webView1.goBack()
        }
        else{
        super.onBackPressed()
        }
    }


    }
