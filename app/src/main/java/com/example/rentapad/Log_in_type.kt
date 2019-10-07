package com.example.rentapad

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.log_in.*
import android.R.attr.data
import android.view.LayoutInflater
import android.widget.Toast
import com.google.zxing.integration.android.IntentResult
import kotlinx.android.synthetic.main.dialog_view.view.*


class Log_in_type : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_in)
 booking.setOnClickListener {
            var intent = Intent(baseContext, booking::class.java)
            startActivity(intent)
            finish()
        }

landlord.setOnClickListener {
    var intent = Intent(baseContext, Landlords::class.java)
    startActivity(intent)

}
tenants.setOnClickListener {
    val builder = AlertDialog.Builder(this)
    // Set the alert dialog title
    builder.setTitle("Tenant")

    // Display a message on alert dialog
    builder.setMessage("Do you want to log in or scan code??")

    // Set a positive button and its click listener on alert dialog
    builder.setPositiveButton("Log In") { dialog, which ->
        //LETS LOGIN WITHOUT SCAN
        var intent = Intent(baseContext, Tenants_log_in::class.java)
        startActivity(intent)
        
       /*   //LOAD NETXT ACTIVITY PASSING VALUES
        val intent = Intent(this@Log_in_type,Tenants::class.java)
        intent.putExtra("barcodeResults","Passed")
        startActivity(intent)
*/




   /* var intent = Intent(baseContext, Tenants::class.java)
    startActivity(intent)
    finish()*/
}
    builder.setNegativeButton("Scan"){dialog, which ->
        val scanner=  IntentIntegrator(this)
        scanner.initiateScan()


    }
    builder.setCancelable(false)
    val dialog: AlertDialog = builder.create()

    // Display the alert dialog on app interface
    dialog.show()



}



}
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Successfully scanned!", Toast.LENGTH_LONG).show()
                val intent = Intent(this@Log_in_type,Tenants::class.java)
                intent.putExtra("barcodeResults",result.contents)
                startActivity(intent)









                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }





    }

    override fun onBackPressed() {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_view, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setCancelable(false)
            .setTitle("Confirm Exit")
        //show dialog
        val  mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.stay.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
            //get text from EditTexts of custom layout
            /*val name = mDialogView.dialogNameEt.text.toString()
            val email = mDialogView.dialogEmailEt.text.toString()
            val password = mDialogView.dialogPasswEt.text.toString()*/
            //set the input text in TextView
           /* mainInfoTv.setText("Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password)*/
        }
        //cancel button click of custom layout
        mDialogView.quit.setOnClickListener {
            //dismiss dialog
            finishAffinity()
        }
    }
    }
