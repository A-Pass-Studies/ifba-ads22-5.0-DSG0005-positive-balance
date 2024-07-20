package com.apass.collegeifba.s50.dsg005.positivebalance.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.navigation.navArgument
import com.apass.collegeifba.s50.dsg005.positivebalance.R
import com.apass.collegeifba.s50.dsg005.positivebalance.model.User

class MainActivity : AppCompatActivity() {

    @IdRes
    private val containerId = R.id.activity_main_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.addFragmentOnAttachListener { _, fragment ->
            when(fragment) {
                is AuthFragment -> {
                    fragment.listeners = object : AuthFragment.AuthFragmentListener {
                        override fun onSucess(user: User) = goToHome(user)

                        override fun onFailure(msg: String) {
                            Toast.makeText(this@MainActivity, "Falha no login", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else -> {

                }
            }
        }

        configureFragments()
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main_fragment_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun configureFragments() = supportFragmentManager.commit {
        replace(containerId, AuthFragment(), "auth")
    }

    private fun goToHome(user: User) = supportFragmentManager.commit {
        replace(containerId, HomeFragment.newInstance(user), "home")
    }
}