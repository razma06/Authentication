package com.example.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
    }

    private fun init(){
        auth = Firebase.auth
        SignIner.setOnClickListener{
            OnLogIn()
        }
    }

    private fun OnLogIn(){
        val emailAdd = signEmail.text.toString()
        val passLog = signPassword.text.toString()
        if(emailAdd.isNotEmpty() && passLog.isNotEmpty()) {
            SignIner.isClickable = false
            signProgress.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(emailAdd, passLog)
                .addOnCompleteListener(this) { task ->
                    SignIner.isClickable = true
                    signProgress.visibility = View.GONE
                    if (task.isSuccessful) {
                        startActivity(Intent(this, SuccessLogin  :: class.java))

                    } else {
                        val report = task.exception
                        Toast.makeText(
                            baseContext, "$report",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }
        }else{
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

}