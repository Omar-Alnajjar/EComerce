package com.testapp.ecomerce.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.testapp.ecomerce.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_products.*

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}