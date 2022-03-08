package com.example.musicgallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.musicgallery.presentation.tracks.TracksFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navHostFragment.navController.navigate(R.id.loginFragment)
    }
    override fun onBackPressed() {
        val fragmentCount = supportFragmentManager.backStackEntryCount
        println(fragmentCount)
        when {
            navHostFragment.navController.currentDestination?.id == R.id.albumsFragment || navHostFragment.navController.currentDestination?.id == R.id.tracksFragment -> {
                navHostFragment.navController.navigate(R.id.tagsFragment)
            }
            fragmentCount > 1 -> {
                super.onBackPressed()
            }
            else -> {
                finish()
            }
        }
    }
}