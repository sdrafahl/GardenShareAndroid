package com.gardenshare.gardenshareapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.gardenshare.gardenshareapp.databinding.ActivityMain3Binding
import com.gardenshare.gardenshareapp.tokenstorage.JWTTokenStore
import com.gardenshare.gardenshareapp.ui.login.LoginActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref: SharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main3)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    override fun onStart() {
        super.onStart()
        val sharedPreferenceName = "com.gardenshare.gardenshareapp"
        val sharedPreferences = this.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE)
        val jwtStore = JWTTokenStore.createStore(sharedPreferences)

        val loginIntent = Intent(this, LoginActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "Routing to Login")
        }

        runBlocking {
            launch {
                if(jwtStore.getToken().isEmpty()) {
                    startActivity(loginIntent)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main3)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}