package edu.rosehulman.kaupaies.carcompanion

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import edu.rosehulman.kaupaies.carcompanion.ui.car_info.CarDetailFragment
import edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting.TroubleShootingTree
import edu.rosehulman.kaupaies.carcompanion.ui.troubleshooting.TroubleshootingFragment

class MainActivity : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        TroubleshootingFragment.OnTroubleSelectedListener {

    private var currentFragment:String = "home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //passing in each menu id
        val bottomNavView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavView.setOnNavigationItemSelectedListener(this)

        title = "CarCompanion"
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var switchTo: Fragment? = null
        Log.d(Constants.TAG, "switching to any fragment")

        when (item.itemId) {
            R.id.navigation_car_detail -> {
                currentFragment = "car detail"
                switchFrag(CarDetailFragment(this))
            }
            R.id.navigation_troubleshooting -> {
                currentFragment = "troubleshooting"
                Log.d(Constants.TAG, "switching to troubleshoot")
                switchFrag(TroubleshootingFragment())
            }
            R.id.navigation_find_help -> {
                currentFragment = "find help"
                switchFrag(FindHelpFragment())
            }
            else -> false
        }
        return true
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
        TODO("Not yet implemented")
    }
}