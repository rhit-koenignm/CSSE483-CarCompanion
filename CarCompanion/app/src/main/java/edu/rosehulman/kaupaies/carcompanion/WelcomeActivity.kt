package edu.rosehulman.kaupaies.carcompanion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    lateinit var authStateListener: FirebaseAuth.AuthStateListener

    private val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
    )

    private val RC_SIGN_IN = 1

    private var currentActivity: String = "WelcomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initializeButtonListeners()
        initializeAuthListeners()
    }

    override fun onStart() {
        super.onStart()
        auth.addAuthStateListener(authStateListener)
        Log.d(Constants.TAG, "added listener to auth")
    }

    private fun switchActivity(activity: AppCompatActivity) {
        val intent = Intent(this@WelcomeActivity, activity::class.java)
        startActivity(intent)
    }

    private fun initializeButtonListeners() {
        btn_login.setOnClickListener {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(), RC_SIGN_IN
            )
        }

        btn_guest.setOnClickListener {
            auth.signInAnonymously()
        }
    }

    private fun initializeAuthListeners() {
        authStateListener = FirebaseAuth.AuthStateListener { auth: FirebaseAuth ->
            val user = auth.currentUser
            Log.d(Constants.TAG, "${user?.uid}")
            if(user != null) {
                this.currentActivity = "MainActivity"
                switchActivity(MainActivity(user.uid, auth, user.isAnonymous))
            } else if(this.currentActivity != "WelcomeActivity") {
                Log.d(Constants.TAG, "should be going back to welcome???")
                this.currentActivity = "WelcomeActivity"
                switchActivity(this)
            }
        }
    }

}