package com.univem.firstapplication.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.univem.firstapplication.R
import com.univem.firstapplication.ui.gist.GistFragment
import com.univem.firstapplication.ui.repository.RepositoryFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(R.layout.activity_home),
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigation.setOnNavigationItemSelectedListener(this)
        if (savedInstanceState == null) {
            loadFragment(RepositoryFragment.newInstance())
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_repositories -> {
                loadFragment(RepositoryFragment.newInstance())
            }
            R.id.nav_gists -> {
                loadFragment(GistFragment.newInstance())
            }
        }
        return true
    }

    private fun loadFragment(fragment: Fragment?) {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment, fragment.javaClass.simpleName)
                .commit()

        }
    }
}