package edu.rosehulman.kaupaies.carcompanion

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import edu.rosehulman.kaupaies.carcompanion.ui.car_info.CarDetailFragment
import edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting.DiagnosisDetailsFragment
import edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting.TroubleShootingTree
import edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting.TroubleshootingFragment

class MainActivity(val user: String, val auth: FirebaseAuth, val isAnon: Boolean) : AppCompatActivity(),
//        NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        TroubleshootingFragment.OnTroubleSelectedListener {

    constructor(): this("N/A", FirebaseAuth.getInstance(), true)

    private var currentFragment:String = "home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        //passing in each menu id
        val bottomNavView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavView.setOnNavigationItemSelectedListener(this)

        title = "CarCompanion"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var switchTo: Fragment? = null

        when (item.itemId) {
            R.id.navigation_car_detail -> {
                currentFragment = "car detail"
                Log.d(Constants.TAG, "user going to car details: $user")
                if(isAnon) {
                    switchFrag(AnonFragment())
                    return true
                }
                switchFrag(CarDetailFragment(this))
            }
            R.id.navigation_troubleshooting -> {
                currentFragment = "troubleshooting"
                switchFrag(TroubleshootingFragment())
            }
            R.id.navigation_find_help -> {
                currentFragment = "find help"
                switchFrag(FindHelpFragment())
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                auth.signOut()
                true
            }
            else -> false
        }
    }

    fun switchFrag(f: Fragment): Boolean {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, f)
        while (supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStackImmediate()
        }
        ft.commit()
        return true
    }

    override fun onTroubleSelected(woe: TroubleShootingTree.Woe) {

        Log.d(Constants.TAG, "Trouble Selected: ${woe.getTitle()}")
        if(woe.woeType.equals("Diagnosis")){
            val detailFragment = DiagnosisDetailsFragment.newInstance(woe.data)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container, detailFragment)
            ft.addToBackStack("detail")
            ft.commit()
        }
        else if(woe.woeType.equals("Symptom"))
        else{
            //This case will be for when a indicator is picked

            //if a non diagnosis is selected then we want to let the adapter know
            //will create function later
        }
    }
}