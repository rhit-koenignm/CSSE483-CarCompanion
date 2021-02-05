package edu.rosehulman.kaupaies.carcompanion

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import edu.rosehulman.kaupaies.carcompanion.ui.home.HomeFragment

class MainActivity : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private var currentFragment:String = "home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "CarCompanion"

        val bottomNavView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavView.setOnNavigationItemSelectedListener(this)

//        val navController = findNavController(R.id.nav_host_fragment)


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_home, R.id.navigation_car_detail, R.id.navigation_troubleshooting))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.navigation_car_detail -> {
                currentFragment = "car detail"
                switchFrag(CarDetailFragment())
            }
            R.id.navigation_troubleshooting -> {
                currentFragment = "troubleshooting"
                switchFrag(TroubleshootingFragment())
            }
            R.id.navigation_find_help -> {
                currentFragment = "find help"
                switchFrag(HomeFragment())
            }
            else -> false
        }
    }

    fun switchFrag(f: Fragment): Boolean {
        Log.d("AAA", "switching fragments")
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.nav_host_fragment, f)
        while (supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStackImmediate()
        }
        ft.commit()
        return true
    }
}