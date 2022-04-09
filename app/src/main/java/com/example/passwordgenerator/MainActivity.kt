 package com.example.passwordgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



 class MainActivity : AppCompatActivity(), View.OnClickListener {

     private var len: Int = 0
     private var password = PasswordGenerator()
     private var etInput: EditText? = null
     private var tvResult: TextView? = null

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         etInput = findViewById(R.id.etLenInput)
         val btnGenerate: Button = findViewById(R.id.btnGenerate)
         tvResult = findViewById(R.id.tvPasswordResult)
//         convert the input to an int

         btnGenerate.setOnClickListener(this)


     }
     private fun validateInput(): Boolean{
         if(etInput?.text.toString().isEmpty()){
             etInput?.error = "Enter a value"
             return false
         }else if(etInput?.text.toString().toInt() > 12 ||
                 etInput?.text.toString().toInt() < 8){
             etInput?.error = "Input must be between 8 and 12"
             return false
         }
         return true
     }

     override fun onClick(view: View?) {
         when(view?.id){
             R.id.btnGenerate -> {
                if(validateInput()){
                    len = etInput?.text.toString().toInt()
                    tvResult?.text = password.generatePassword(len)
                }
             }
         }
     }


 }
