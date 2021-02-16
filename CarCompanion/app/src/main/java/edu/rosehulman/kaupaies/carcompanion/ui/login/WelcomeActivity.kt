package edu.rosehulman.kaupaies.carcompanion.ui.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import edu.rosehulman.kaupaies.carcompanion.Constants
import edu.rosehulman.kaupaies.carcompanion.MainActivity
import edu.rosehulman.kaupaies.carcompanion.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    lateinit var authStateListener: FirebaseAuth.AuthStateListener

    val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
    )

    val RC_SIGN_IN = 1

    private val GUEST_UID = "CAR_COMPANION_GUEST_USER"

    private var currentActivity: Activity = this

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
            Log.d(Constants.TAG, "signing up anon, id = ${auth.currentUser}")
        }
    }

    private fun initializeAuthListeners() {
        authStateListener = FirebaseAuth.AuthStateListener { auth: FirebaseAuth ->
            val user = auth.currentUser
            Log.d(Constants.TAG, "listener doing something")
            Log.d(Constants.TAG, currentActivity.toString())
            if(user != null) {
                Log.d(Constants.TAG, "${user.email}")
                this.currentActivity = MainActivity(user.uid, auth)
                switchActivity(this.currentActivity as MainActivity)
            } else if(this.currentActivity != this) {
                this.currentActivity = this
                switchActivity(this)
            }
        }
    }


}