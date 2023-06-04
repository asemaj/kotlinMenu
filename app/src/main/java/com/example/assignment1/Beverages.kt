package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Beverages.newInstance] factory method to
 * create an instance of this fragment.
 */
class Beverages : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    val itemList = mutableListOf<FoodItem>()

    private val foodItemList = mutableListOf<FoodItem>()
    private val selectedFoodItems = mutableListOf<FoodItem>()


    private lateinit var pespiImageView: ImageView
    private lateinit var pepsiDescriptionTextView: TextView
    private lateinit var pepsiButton: Button

    private lateinit var spriteButton: Button
    private lateinit var spriteImageView: ImageView
    private lateinit var spriteDescriptionTextView: TextView

    private lateinit var cocacolaButton: Button
    private lateinit var cocacolaImageView: ImageView
    private lateinit var cocacolaDescriptionTextView: TextView

    private lateinit var appleButton: Button
    private lateinit var appleImageView: ImageView
    private lateinit var appleDescriptionTextView: TextView

    private lateinit var waterButton: Button
    private lateinit var waterImageView: ImageView
    private lateinit var waterDescriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beverages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val cartImageView = requireActivity().findViewById<ImageView>(R.id.cartBtn)

        val intent = Intent(requireContext(), CartActivity::class.java)

        pespiImageView = view.findViewById(R.id.pepsi)
        pepsiDescriptionTextView = view.findViewById(R.id.pepsiDescription)
        pepsiButton = view.findViewById(R.id.pepsiBtn)

        spriteImageView = view.findViewById(R.id.sprite)
        spriteDescriptionTextView = view.findViewById(R.id.spriteDescription)
        spriteButton = view.findViewById(R.id.spriteBtn)

        cocacolaImageView = view.findViewById(R.id.cocaCola)
        cocacolaDescriptionTextView = view.findViewById(R.id.cocaclaDescription)
        cocacolaButton = view.findViewById(R.id.cocaColaBtn)

        appleImageView = view.findViewById(R.id.apple)
        appleDescriptionTextView = view.findViewById(R.id.appleDescription)
        appleButton = view.findViewById(R.id.appleBtn)


        waterImageView = view.findViewById(R.id.water)
        waterDescriptionTextView = view.findViewById(R.id.waterDescription)
        waterButton = view.findViewById(R.id.waterBtn)




        pepsiButton.setOnClickListener {
            val itemName = "pepsi"
            val itemPrice = pepsiButton.text.toString()
            val itemImageResId = R.drawable.pepsi

            val item = FoodItem(itemName, itemImageResId, itemPrice.toDoubleOrNull() ?: 0.0)

            itemList.add(item)

            val selectedItem = itemList.find { it.name == itemName }
            if (selectedItem != null) {
                val selectedIndex = itemList.indexOf(selectedItem)
                val selectedFoodItem = itemList.removeAt(selectedIndex)
                itemList.add(0, selectedFoodItem)
            }

            intent.putExtra("itemName", itemName)
            intent.putExtra("itemPrice", itemPrice)
            intent.putExtra("itemImageResId", itemImageResId)
        }

        spriteButton.setOnClickListener {
            val itemName = "sprite"
            val itemPrice = spriteButton.text.toString()
            val itemImageResId = R.drawable.sprite

            intent.putExtra("itemName", itemName)
            intent.putExtra("itemPrice", itemPrice)
            intent.putExtra("itemImageResId", itemImageResId)

        }
        cocacolaButton.setOnClickListener {
            val itemName = "buffalo"
            val itemPrice = cocacolaButton.text.toString()
            val itemImageResId = R.drawable.cocacola

            val item = FoodItem(itemName, itemImageResId, itemPrice.toDoubleOrNull() ?: 0.0)

            itemList.add(item)

            val selectedItem = itemList.find { it.name == itemName }
            if (selectedItem != null) {
                val selectedIndex = itemList.indexOf(selectedItem)
                val selectedFoodItem = itemList.removeAt(selectedIndex)
                itemList.add(0, selectedFoodItem)
            }

            intent.putExtra("itemName", itemName)
            intent.putExtra("itemPrice", itemPrice)
            intent.putExtra("itemImageResId", itemImageResId)
        }

        appleButton.setOnClickListener {
            val itemName = "apple"
            val itemPrice = appleButton.text.toString()
            val itemImageResId = R.drawable.apple

            val item = FoodItem(itemName, itemImageResId, itemPrice.toDoubleOrNull() ?: 0.0)

            itemList.add(item)

            val selectedItem = itemList.find { it.name == itemName }
            if (selectedItem != null) {
                val selectedIndex = itemList.indexOf(selectedItem)
                val selectedFoodItem = itemList.removeAt(selectedIndex)
                itemList.add(0, selectedFoodItem)
            }

            intent.putExtra("itemName", itemName)
            intent.putExtra("itemPrice", itemPrice)
            intent.putExtra("itemImageResId", itemImageResId)
        }

        waterButton.setOnClickListener {
            val itemName = "water"
            val itemPrice = waterButton.text.toString()
            val itemImageResId = R.drawable.water

            val item = FoodItem(itemName, itemImageResId, itemPrice.toDoubleOrNull() ?: 0.0)

            itemList.add(item)

            val selectedItem = itemList.find { it.name == itemName }
            if (selectedItem != null) {
                val selectedIndex = itemList.indexOf(selectedItem)
                val selectedFoodItem = itemList.removeAt(selectedIndex)
                itemList.add(0, selectedFoodItem)
            }

            intent.putExtra("itemName", itemName)
            intent.putExtra("itemPrice", itemPrice)
            intent.putExtra("itemImageResId", itemImageResId)
        }

        cartImageView.setOnClickListener(){
            startActivity(intent)
        }
        
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Beverages.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Beverages().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}