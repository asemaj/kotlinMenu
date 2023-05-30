package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


data class FoodItem(val name: String, val imageResId: Int, val price: Double)

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: CartAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)

        val locationButton = findViewById<Button>(R.id.Location)
        locationButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }


        val checkoutPriceTextView: TextView = findViewById(R.id.CheckoutPrice)

        // Find the first empty slot in the cart
        var index = 1
        var itemNameTextView: TextView? = null
        var itemPriceTextView: TextView? = null
        var itemImageView: ImageView? = null

        while (index <= 7) {
            itemNameTextView = findViewById(resources.getIdentifier("item${index}NameTextView", "id", packageName))
            itemPriceTextView = findViewById(resources.getIdentifier("item${index}PriceTextView", "id", packageName))
            itemImageView = findViewById(resources.getIdentifier("item${index}ImageView", "id", packageName))

            if (itemNameTextView.text == "TextView") {
                // Found an empty slot, break the loop
                break
            }

            index++
        }

        // Get the data from the intent
        val itemName = intent.getStringExtra("itemName")
        val itemPrice = intent.getStringExtra("itemPrice")
        val itemImageResId = intent.getIntExtra("itemImageResId", 0)

        // Display the data in the empty slot
        itemNameTextView?.text = itemName
        itemPriceTextView?.text = itemPrice
        itemImageView?.setImageResource(itemImageResId)

        // Set the visibility of the views based on whether the item is present
        if (itemName.isNullOrEmpty() || itemName == "TextView") {
            itemNameTextView?.visibility = View.GONE
            itemPriceTextView?.visibility = View.GONE
            itemImageView?.visibility = View.GONE
        } else {
            itemNameTextView?.visibility = View.VISIBLE
            itemPriceTextView?.visibility = View.VISIBLE
            itemImageView?.visibility = View.VISIBLE
        }
        calculateTotalPrice()


    }

    private fun calculateTotalPrice() {
        var index = 1
        var totalPrice = 0.0
        while (index <= 7) {
            val itemPriceTextView = findViewById<TextView>(resources.getIdentifier("item${index}PriceTextView", "id", packageName))
            val priceString = itemPriceTextView.text.toString()

            if (priceString.isNotEmpty()) {
                val itemPrice = priceString.toDoubleOrNull()
                if (itemPrice != null) {
                    totalPrice += itemPrice
                } else {
                }
            }

            index++
        }

        val checkoutPriceTextView = findViewById<TextView>(R.id.CheckoutPrice)
        checkoutPriceTextView.text = totalPrice.toString()
    }


    private fun openMapsFragment() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }



    private fun getFoodItemList(): List<FoodItem> {
        // Replace this with your logic to retrieve the list of food items from the database or any other source
        // This is just a sample implementation

        val foodItemList = mutableListOf<FoodItem>()
        foodItemList.add(FoodItem("Steak", R.drawable.stake, 22.00))
        foodItemList.add(FoodItem("Lasagna", R.drawable.lasagna, 10.00))
        foodItemList.add(FoodItem("Meatballs", R.drawable.meatball, 8.00))
        foodItemList.add(FoodItem("Baked Potato", R.drawable.potato, 6.50))
        foodItemList.add(FoodItem("Tacos", R.drawable.taco, 9.00))

        return foodItemList
    }
}
