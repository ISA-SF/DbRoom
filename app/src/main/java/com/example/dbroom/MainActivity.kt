package com.example.dbroom

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.dbroom.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        screenSplash.setKeepOnScreenCondition { true }
        startActivity(Intent(this, crud_data::class.java))
        finish()
    }

    fun checkoutCommit(){
        Log.d(ContentValues.TAG, "prueba para ver el checkout commit en nueva rama")
    }

    fun nuevoCommit(){
        Log.d(ContentValues.TAG, "commit x")
    }

    fun checkoutCommit2(){
        Log.d(ContentValues.TAG, "commit x2")
    }

}