package com.example.rentapad

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_secondpage.*

class Secondpage : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondpage)

        loadContent()

      val btn = findViewById<Button>(R.id.button1)
        btn.setOnClickListener(){

            //LETS BUILD A DIALOG FOR EITHER TURNIN ON WIFI OR DATA
            val builder = AlertDialog.Builder(this)
            // Set the alert dialog title
            builder.setTitle("Internet Connection")

            // Display a message on alert dialog
            builder.setMessage("Do you want to use WI-FI or data?")

            // Set a positive button and its click listener on alert dialog
            builder.setPositiveButton("WI-FI") { dialog, which ->
                // Do something when user press the positive button
                /* Toast.makeText(applicationContext,"Ok, we change the app background.",Toast.LENGTH_SHORT).show()*/


                //OPEN WIFI SETTINGS
                val intent = Intent(Intent.ACTION_MAIN)
                intent.setClassName("com.android.settings", "com.android.settings.wifi.WifiSettings")
                startActivity(intent)

                Handler().postDelayed({
                    //doSomethingHere()
                    test()

                }, 10000)

                /* internetTest()*/






             // Display a negative button on alert dialog
            builder.setNegativeButton("DATA") { dialog, which ->

                //OPEN DATA SETTINGS
                val intent = Intent(Intent.ACTION_MAIN)
                intent.setComponent( ComponentName("com.android.settings","com.android.settings.Settings\$DataUsageSummaryActivity"))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)


                Handler().postDelayed({
                    //doSomethingHere()

                    test()
                }, 10000)

            }










            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()
        }
    }



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else  if (webView2!!.canGoBack()) {
            webView2!!.goBack()
        }
        else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.secondpage, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    //FUNCTION FOR TESTING INTERNET CONNECTION AGIN
    fun test() {


        //*MY CODE TO TEST INTERNET CONNECTIVITY STATUS
        val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo

        //IF NETWORK IS THERE
        if (networkInfo != null && networkInfo.isConnected) {
            card2.visibility=View.GONE
            linearLayoutCompat.visibility = View.VISIBLE

        } else {

            //LETS GO TO THE NEXT MAIN ACTIVITY
         /*   var intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()*/

            card2.visibility=View.VISIBLE
            linearLayoutCompat.visibility = View.GONE
            webView2.visibility=View.GONE

        }
    }


    //FUNCTION FOR LOADING THE SITE TO THE WEBVIEW
    fun loadContent() {

        //WEBVIEW SETTINGS
        if (webView2 != null) {
            val webSettings = webView2!!.settings
            webSettings!!.javaScriptEnabled = true
            webView2!!.webViewClient = WebViewClient()
            webView2!!.webChromeClient = WebChromeClient()
            webView2!!.loadUrl("http://remolatitude-001-site1.dtempurl.com/Website/Welcome_page.aspx")

            //WHEN THE PAGE STARTS TO LOAD PROGRESSBAR IS SET TO  VISSIBLE
            webView2!!.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    test()
                    linearLayoutCompat.visibility = View.VISIBLE
                    webView2.visibility = View.GONE
                    //NOW INTERNET IS AVAILLABLE LETS
                    super.onPageStarted(view, url, favicon)

                }

                //WHEN THE PAGE FINISH TO LOAD THE PROGRESSBAR IS SET TO INVISSIBLE
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    linearLayoutCompat.visibility = View.GONE

                    webView2.visibility = View.VISIBLE
                    super.onPageFinished(view, url)

                }
            }
        }
        //WHENEVER THE BACK BUTTON IS PRESSED THIS TAKES PLACE


}
  /*  override fun onBackPressed() {

        if (webView2!!.canGoBack()) {
            webView2!!.goBack()
        }

        super.onBackPressed()

    }*/
}