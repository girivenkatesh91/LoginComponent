package com.equadriga.logincomponent

import android.app.Activity
import android.content.Context
import android.content.Intent

object LoginComponent {
    fun launch(
        context: Context,
        requestCode: Int = 1001,
        usernameHint: String = "Username",
        passwordHint: String = "Password",
        buttonText: String = "Login"
    ) {
        val intent = Intent(context, LoginActivity::class.java).apply {
            putExtra("USERNAME_HINT", usernameHint)
            putExtra("PASSWORD_HINT", passwordHint)
            putExtra("BUTTON_TEXT", buttonText)
        }

        if (context is Activity) {
            context.startActivityForResult(intent, requestCode)
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}

