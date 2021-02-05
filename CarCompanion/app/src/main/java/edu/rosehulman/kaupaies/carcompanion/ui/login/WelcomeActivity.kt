package edu.rosehulman.kaupaies.carcompanion.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.rosehulman.kaupaies.carcompanion.MainActivity
import edu.rosehulman.kaupaies.carcompanion.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btn_login.setOnClickListener {
            switchActivity(LoginActivity())
        }

        btn_signup.setOnClickListener {
            switchActivity(SignUpActivity())
        }

        btn_guest.setOnClickListener {
            switchActivity(MainActivity())
        }
    }

    private fun switchActivity(activity: AppCompatActivity) {
        val intent = Intent(this@WelcomeActivity, activity::class.java)
        startActivity(intent)
    }
}