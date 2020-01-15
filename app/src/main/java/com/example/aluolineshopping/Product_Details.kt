package com.example.aluolineshopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product__details.*
import kotlinx.android.synthetic.main.shopping_ticket.*

class Product_Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product__details)
        val  bundle = intent.extras

        iv_image.setImageResource(bundle!!.getInt("image"))
        tv_name.text=bundle!!.getString("name")
        tvdes.text= bundle!!.getString("des")
    }
}
