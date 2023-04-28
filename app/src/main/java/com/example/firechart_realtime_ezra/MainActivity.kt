package com.example.firechart_realtime_ezra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var make_edt:EditText
    lateinit var model_edt:EditText
    lateinit var price_edt:EditText
    lateinit var pht_btn:Button
    lateinit var cdata_btn:Button
    lateinit var cview_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        make_edt = findViewById(R.id.edt_make)
        model_edt = findViewById(R.id.edt_mod)
        price_edt = findViewById(R.id.edt_price)
        pht_btn = findViewById(R.id.btn_pht)
        cdata_btn = findViewById(R.id.btn_cdata)
        cview_btn  = findViewById(R.id.btn_cview)

        // Initialize firebase
        var database = FirebaseDatabase.getInstance()
        var databaseref = database.getReference("cars")
        pht_btn.setOnClickListener {

        }
        cdata_btn.setOnClickListener {
          var make = make_edt.text.toString().trim()
          var model = model_edt.text.toString().trim()
          var price = price_edt.text.toString().trim()
          //Validate User Entries
            if(make.isEmpty()||model.isEmpty()||price.isEmpty()){
                Toast.makeText(this, "Cannot Subvmit an Empty Field!", Toast.LENGTH_SHORT).show()
            }else{
                //save data to the firebase db
                var usercar = Car(make,model,price )
                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "Car Data Uploaded successfully!", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Failed to upload car data!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        cview_btn.setOnClickListener {

        }
    }
}