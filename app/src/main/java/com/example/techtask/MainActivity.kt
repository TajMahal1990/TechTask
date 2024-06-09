package com.example.techtask

import ItemsAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val itemList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", "blueebackpack","",109.99 ))
        items.add(Item(2, "Mens Casual Premium Slim Fit T-Shirts", "whitetshirt",   "", 22.3 ))
        items.add(Item(3, "Mens Casual Slim Fit", "blueturtleneck", "Смарт-часы Apple Watch Series 9: Инновации и Стиль на Вашем Запястье", 15.99,))
        items.add(Item(4, "Mens Cotton Jacket", "brownjelly", "Смарт-часы Apple Watch Series 9: Инновации и Стиль на Вашем Запястье", 55.99,))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = ItemsAdapter(items, this)

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = ItemsAdapter(items, this)
    }
}




