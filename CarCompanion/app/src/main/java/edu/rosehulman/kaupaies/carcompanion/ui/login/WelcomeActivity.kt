package edu.rosehulman.kaupaies.carcompanion.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import edu.rosehulman.kaupaies.carcompanion.MainActivity
import edu.rosehulman.kaupaies.carcompanion.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 1;
    private val auth = FirebaseAuth.getInstance()
    lateinit var authStateListener: FirebaseAuth.AuthStateListener

    private val GUEST_UID = "CAR_COMPANION_GUEST_USER"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initializeButtonListeners()
        initializeAuthListeners()
    }

    override fun onStart() {
        super.onStart()
        auth.addAuthStateListener(this.authStateListener)
    }

    override fun onStop() {
        super.onStop()
        auth.removeAuthStateListener(this.authStateListener)
    }

    private fun switchActivity(activity: AppCompatActivity) {
        val intent = Intent(this@WelcomeActivity, activity::class.java)
        startActivity(intent)
    }

    private fun initializeButtonListeners() {
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

    private fun initializeAuthListeners() {
        authStateListener = FirebaseAuth.AuthStateListener { auth: FirebaseAuth ->
            val user = auth.currentUser
            if(user != null) {
                switchActivity(MainActivity(user.uid))
            }


        }
    }


}