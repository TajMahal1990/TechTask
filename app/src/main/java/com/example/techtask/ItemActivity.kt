package com.example.techtask

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val image: ImageView = findViewById(R.id.item_list_image)
        val title: TextView = findViewById(R.id.item_list_title)
        val catarory: TextView = findViewById(R.id.item_list_catagory)
        val price : TextView = findViewById(R.id.item_list_price)
        val decription: TextView = findViewById(R.id.item_list_description)
        val buttonBuy: ImageButton = findViewById(R.id.item_list_button_buy)

        title.text = intent.getStringExtra("itemTitle")
        decription.text = intent.getStringExtra("itemText")

    }
}