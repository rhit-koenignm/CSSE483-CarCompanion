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
    }

    private fun initializeButtonListeners() {
        btn_login.setOnClickListener {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .setIsSmartLockEnabled(false)
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
            if(user != null) {
                this.currentActivity = "MainActivity"

                val inputIntent = Intent(this, MainActivity::class.java)
                inputIntent.putExtra(USER_UID, user.uid)
                inputIntent.putExtra(IS_ANON, user.isAnonymous)
                Log.d(Constants.TAG, "user: ${user?.uid} ${user?.email} ${user?.isAnonymous}")
                startActivity(inputIntent)
            } else if(this.currentActivity != "WelcomeActivity") {
                this.currentActivity = "WelcomeActivity"
                val intent = Intent(this@WelcomeActivity, this::class.java)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val USER_UID = "USER_UID"
        const val IS_ANON = "IS_ANON"
    }

}