package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.R.id
import com.example.assignment1.R.layout

data class Item(
    val name: String,
    val price: Double?,
    val imageResId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(name)
        if (price != null) {
            parcel.writeDouble(price)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}


class MainActivity : AppCompatActivity(),OnItemSelectionListener {
    val itemList = mutableListOf<FoodItem>()

    override fun onItemSelected(item: FoodItem) {
        itemList.add(item)
    }


//    private val itemList = listOf(
//        Item(R.drawable.stake, "Steak", 22.0),
//        Item(R.drawable.lasagna, "lasagna", 10.0),
//        Item(R.drawable.meatball, "meatballs", 8.0),
//        Item(R.drawable.potato, "Baked Potato", 6.5),
//        Item(R.drawable.taco, "Tacos", 9.0),
//        Item(R.drawable.pepsi, "Pepsi", 3.0),
//        Item(R.drawable.sprite, "sprite", 3.0),
//        Item(R.drawable.cocacola, "cocacola", 3.0),
//        Item(R.drawable.apple, "apple juice", 3.0),
//        Item(R.drawable.water, "water", 2.0),
//        Item(R.drawable.ketchup, "ketchup", 0.5),
//        Item(R.drawable.mayo, "mayo", 0.5),
//        Item(R.drawable.buffalo, "buffalo sauce", 0.5),
//        Item(R.drawable.ranch, "ranch sauce", 0.5)
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val spinnerVal: Spinner = findViewById(id.menuOptions)
        val defaultFragment = Default()
        val foodFragment = FoodFragment()
        val beveragesFragment = Beverages()
        val sidesFragment = Sides()

        var flag: String = "Menu"

        val cartBtn: ImageView = findViewById(R.id.cartBtn)

        cartBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, CartActivity::class.java)
            intent.putExtra("itemList", ArrayList(itemList))
            startActivity(intent)
        }




        var options = arrayOf("Menu", "food", "beverages", "sides")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        supportFragmentManager.beginTransaction().apply {
            replace(id.DefaultLayout, defaultFragment)
            commit()
        }

        val backVal: Button = findViewById(R.id.back)
        backVal.setOnClickListener { view ->
            flag = "Menu"
            supportFragmentManager.beginTransaction().apply {
                replace(id.DefaultLayout, defaultFragment)
                commit()
            }
        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
                var fragment = foodFragment

                if (flag == "Menu") {
                    supportFragmentManager.beginTransaction().apply {
                        replace(id.DefaultLayout, defaultFragment)
                        commit()
                    }
                } else if (flag == "food") {
                    supportFragmentManager.beginTransaction().apply {
                        replace(id.DefaultLayout, foodFragment)
                        commit()

                    }
                } else if (flag == "beverages") {
                    supportFragmentManager.beginTransaction().apply {
                        replace(id.DefaultLayout, beveragesFragment)
                        commit()
                    }
                } else {
                    supportFragmentManager.beginTransaction().apply {
                        replace(id.DefaultLayout, sidesFragment)
                        commit()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Main -> {
                val fragment = FoodFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.DefaultLayout, fragment)
                    .commit()
                return true
            }
            R.id.Beverages -> {
                val fragment = Beverages()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.DefaultLayout, fragment)
                    .commit()
                return true
            }
            R.id.Sides -> {
                val fragment = Sides()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.DefaultLayout, fragment)
                    .commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
