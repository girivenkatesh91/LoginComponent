package com.equadriga.logincomponent

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameHint = intent.getStringExtra("USERNAME_HINT") ?: "Username"
        val passwordHint = intent.getStringExtra("PASSWORD_HINT") ?: "Password"
        val buttonText = intent.getStringExtra("BUTTON_TEXT") ?: "Login"

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)

        etUsername.hint = usernameHint
        etPassword.hint = passwordHint
        btnLogin.text = buttonText

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == "admin" && password == "1234") {
                setResult(Activity.RESULT_OK)
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

