package com.example.mvvmshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// renamed MainActivity to ShoppingActivity
class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
    }
}