package com.example.assignment1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.R.id


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinnerVal: Spinner = findViewById(id.menuOptions)

        val defaultFragment = Default()
        val foodFragment = Food()
        val beveragesFragment = Beverages()
        val sidesFragment = Sides()
        var flag: String = "Menu"





        var options = arrayOf("Menu","food", "beverages", "sides")
        spinnerVal.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

            supportFragmentManager.beginTransaction().apply {
                replace(id.DefaultLayout, defaultFragment)
                commit()
            }



        val backVal: Button = findViewById(R.id.back)

        backVal.setOnClickListener{ view ->
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

                if(flag == "Menu"){
                    supportFragmentManager.beginTransaction().apply {
                        replace(id.DefaultLayout, defaultFragment)
                        commit()
                    }
                }
                else if(flag == "food"){
                    supportFragmentManager.beginTransaction().apply {
                        replace(id.DefaultLayout, foodFragment)
                        commit()
                    }
                }
                else if(flag == "beverages") {
                    supportFragmentManager.beginTransaction().apply {
                        replace(id.DefaultLayout, beveragesFragment)
                        commit()
                    }
                }
                else {
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
}
