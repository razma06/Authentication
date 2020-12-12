package com.example.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        SignInButton.setOnClickListener{
            val intent = Intent(this, SignIn :: class.java)
            startActivity(intent)
        }
        SignUpButton.setOnClickListener{
            val intent = Intent(this, SignUp :: class.java)
            startActivity(intent)
        }
    }
}