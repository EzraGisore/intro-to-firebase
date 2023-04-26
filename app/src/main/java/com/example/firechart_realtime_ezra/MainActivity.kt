package com.example.firechart_realtime_ezra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var data_edt:EditText
    lateinit var save_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data_edt = findViewById(R.id.edt_data)
        save_btn = findViewById(R.id.btn_save)
        // Initialize firebase
        var database = FirebaseDatabase.getInstance()
        var databaseref = database.reference
        save_btn.setOnClickListener {
            var user_data = data_edt.text.toString().trim()
            //Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
            databaseref.setValue(user_data)

        }
    }
}