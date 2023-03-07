package com.furkasm.mydiaryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.furkasm.mydiaryapp.databinding.ActivitySignUpPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpPage : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpPageBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth





        binding.signUpButton.setOnClickListener {
            val email = binding.signUpEmailAddress.text.toString()
            val password = binding.signUpPassword.text.toString()

                 if (email.isNotEmpty() && password.isNotEmpty()) {
                    auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

                        val intent = Intent(this@SignUpPage, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }.addOnFailureListener {
                        Toast.makeText(this@SignUpPage, it.localizedMessage, Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this@SignUpPage,"Empty Area",Toast.LENGTH_LONG).show()
                 }
            }


        }



}