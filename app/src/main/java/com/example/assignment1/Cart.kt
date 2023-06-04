package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
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

        val itemNames = arrayOf("Steak", "lasagna", "MeatBalls", "Baked Potato", "Tacos")

        val itemName = intent.getStringExtra("itemName")
        val itemPrice = intent.getStringExtra("itemPrice")
        val itemImageResId = intent.getIntExtra("itemImageResId", 0)

        var itemNameTextView: TextView? = null
        var itemPriceTextView: TextView? = null
        var itemImageView: ImageView? = null


        for (index in 1..7) {
            itemNameTextView = findViewById(resources.getIdentifier("item${index}NameTextView", "id", packageName))
            itemPriceTextView = findViewById(resources.getIdentifier("item${index}PriceTextView", "id", packageName))
            itemImageView = findViewById(resources.getIdentifier("item${index}ImageView", "id", packageName))

            val currentItemName = itemNameTextView.text.toString()
            val existingItemImage = itemImageView.drawable

            if (currentItemName.isNullOrEmpty() || existingItemImage == null) {
                itemNameTextView.text = itemName
                itemPriceTextView.text = itemPrice
                itemImageView.setImageResource(itemImageResId)

                itemNameTextView.visibility = View.VISIBLE
                itemPriceTextView.visibility = View.VISIBLE
                itemImageView.visibility = View.VISIBLE

                break
            }
        }



//        val itemName = intent.getStringExtra("itemName")
//        val itemPrice = intent.getStringExtra("itemPrice")
//        val itemImageResId = intent.getIntExtra("itemImageResId", 0)
0
        itemNameTextView?.text = itemName
        itemPriceTextView?.text = itemPrice
        itemImageView?.setImageResource(itemImageResId)
        calculateTotalPrice()

        if (itemName.isNullOrEmpty() || itemName == "TextView") {
            itemNameTextView?.visibility = View.GONE
            itemPriceTextView?.visibility = View.GONE
            itemImageView?.visibility = View.GONE
        } else {
            itemNameTextView?.visibility = View.VISIBLE
            itemPriceTextView?.visibility = View.VISIBLE
            itemImageView?.visibility = View.VISIBLE
        }



        var slot1:LinearLayout = findViewById(R.id.slot1)
        var slot2:LinearLayout = findViewById(R.id.slot2)
        var slot3:LinearLayout = findViewById(R.id.slot3)
        var slot4:LinearLayout = findViewById(R.id.slot4)
        var slot5:LinearLayout = findViewById(R.id.slot5)
        var slot6:LinearLayout = findViewById(R.id.slot6)


        var removebtn: Button = findViewById(R.id.removeItem1)
        var removebtn1: Button = findViewById(R.id.removeItem2)
        var removebtn2: Button = findViewById(R.id.removeItem3)
        var removebtn3: Button = findViewById(R.id.removeItem4)
        var removebtn4: Button = findViewById(R.id.removeItem5)
        var removebtn5: Button = findViewById(R.id.removeItem6)
        var removebtn6: Button = findViewById(R.id.removeItem7)



        removebtn.setOnClickListener{
            var image: ImageView = findViewById(R.id.item1ImageView)
            var name: TextView = findViewById(R.id.item1NameTextView)
            var price: TextView = findViewById(R.id.item1PriceTextView)
            removebtn.visibility = View.GONE
            image.visibility = View.GONE
            name.visibility = View.GONE
            price.visibility = View.GONE

        }

        removebtn1.setOnClickListener {
            slot1.visibility = View.GONE
        }

        removebtn2.setOnClickListener {
            slot2.visibility = View.GONE
        }

        removebtn3.setOnClickListener {
            slot3.visibility = View.GONE
        }

        removebtn4.setOnClickListener {
            slot4.visibility = View.GONE
        }

        removebtn5.setOnClickListener {
            slot5.visibility = View.GONE
        }

        removebtn6.setOnClickListener {
            slot6.visibility = View.GONE
        }


        }




    private fun calculateTotalPrice() {
        val checkoutPriceTextView: TextView = findViewById(R.id.CheckoutPrice)
        var index = 1
        var totalPrice = 0.0
        while (index <= 7) {
            val itemPriceTextView = findViewById<TextView>(resources.getIdentifier("item${index}PriceTextView", "id", packageName))
            val priceString = itemPriceTextView.text.toString()

            if (priceString.isNotEmpty()) {
                val itemPrice = priceString.toDoubleOrNull()
                if (itemPrice != null) {
                    totalPrice += itemPrice
                    val checkoutPriceTextView = findViewById<TextView>(R.id.CheckoutPrice)
                    checkoutPriceTextView.text = totalPrice.toString()
                } else {
                }

                checkoutPriceTextView.text = totalPrice.toString();
            }

            index++
        }


    }


    private fun openMapsFragment() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }



    private fun getFoodItemList(): List<FoodItem> {


        val foodItemList = mutableListOf<FoodItem>()
        foodItemList.add(FoodItem("Steak", R.drawable.stake, 22.00))
        foodItemList.add(FoodItem("Lasagna", R.drawable.lasagna, 10.00))
        foodItemList.add(FoodItem("Meatballs", R.drawable.meatball, 8.00))
        foodItemList.add(FoodItem("Baked Potato", R.drawable.potato, 6.50))
        foodItemList.add(FoodItem("Tacos", R.drawable.taco, 9.00))

        return foodItemList
    }
}
