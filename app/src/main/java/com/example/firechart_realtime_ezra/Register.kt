package com.example.firechart_realtime_ezra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.app

class Register : AppCompatActivity() {
    lateinit var name_reg:EditText
    lateinit var email_reg:EditText
    lateinit var pass_reg:EditText
    lateinit var cre_btn:EditText
    //Initialize firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        name_reg = findViewById(R.id.edt_name_reg)
        email_reg = findViewById(R.id.edt_email_reg)
        pass_reg = findViewById(R.id.edt_pass_reg)
        cre_btn = findViewById(R.id.btn_cre_reg)

        //Initialize firebase again
        auth = FirebaseAuth.getInstance()

        cre_btn.setOnClickListener {
            var name_r = name_reg.text.toString().trim()
            var email_r = email_reg.text.toString().trim()
            var pass_r = pass_reg.text.toString().trim()
            //Validate entries
            if (name_r.isEmpty()||email_r.isEmpty()||pass_r.isEmpty()){
                Toast.makeText(this, "Invalid Entry!", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email_r, pass_r).addOnCompleteListener(this){
                    if(it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        //
                    }else{
                        Toast.makeText(this, "Failed to Create Account.", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}