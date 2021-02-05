package edu.rosehulman.kaupaies.carcompanion.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.rosehulman.kaupaies.carcompanion.MainActivity
import edu.rosehulman.kaupaies.carcompanion.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup_submit_btn.setOnClickListener {
            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}