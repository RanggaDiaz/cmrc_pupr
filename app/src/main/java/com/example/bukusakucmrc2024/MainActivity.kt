package com.example.riskmonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.riskmonitoring.HomeFragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.nav_menu1 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Menu1Fragment()).commit()
            R.id.nav_menu2 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Menu2Fragment()).commit()
            R.id.nav_menu3 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Menu3Fragment()).commit()
            R.id.nav_menu4 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Menu4Fragment()).commit()
            R.id.nav_menu5 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Menu5Fragment()).commit()
            R.id.nav_menu6 -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Menu6Fragment()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}