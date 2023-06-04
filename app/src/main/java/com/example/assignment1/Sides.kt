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
 * Use the [Sides.newInstance] factory method to
 * create an instance of this fragment.
 */
class Sides : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    val itemList = mutableListOf<FoodItem>()

    private val foodItemList = mutableListOf<FoodItem>()
    private val selectedFoodItems = mutableListOf<FoodItem>()


    private lateinit var ketchupImageView: ImageView
    private lateinit var ketchupDescriptionTextView: TextView
    private lateinit var ketchupButton: Button

    private lateinit var mayoButton: Button
    private lateinit var mayoImageView: ImageView
    private lateinit var mayoDescriptionTextView: TextView

    private lateinit var buffaloButton: Button
    private lateinit var buffaloImageView: ImageView
    private lateinit var buffaloDescriptionTextView: TextView

    private lateinit var ranchButton: Button
    private lateinit var ranchImageView: ImageView
    private lateinit var ranchDescriptionTextView: TextView


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
        return inflater.inflate(R.layout.fragment_sides, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val cartImageView = requireActivity().findViewById<ImageView>(R.id.cartBtn)

        val intent = Intent(requireContext(), CartActivity::class.java)

        ketchupImageView = view.findViewById(R.id.ketchup)
        ketchupDescriptionTextView = view.findViewById(R.id.ketchupDescription)
        ketchupButton = view.findViewById(R.id.ketchupBtn)

        mayoImageView = view.findViewById(R.id.mayo)
        mayoDescriptionTextView = view.findViewById(R.id.mayoDescription)
        mayoButton = view.findViewById(R.id.mayoBtn)

        buffaloImageView = view.findViewById(R.id.buffalo)
        buffaloDescriptionTextView = view.findViewById(R.id.cocaclaDescription)
        buffaloButton = view.findViewById(R.id.BuffaloBtn)

        ranchImageView = view.findViewById(R.id.ranch)
        ranchDescriptionTextView = view.findViewById(R.id.ranchDescription)
        ranchButton = view.findViewById(R.id.ranchBtn)





        ketchupButton.setOnClickListener {
            val itemName = "ketckup"
            val itemPrice = ketchupButton.text.toString()
            val itemImageResId = R.drawable.ketchup

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

        mayoButton.setOnClickListener {
            val itemName = "mayo"
            val itemPrice = mayoButton.text.toString()
            val itemImageResId = R.drawable.mayo

            intent.putExtra("itemName", itemName)
            intent.putExtra("itemPrice", itemPrice)
            intent.putExtra("itemImageResId", itemImageResId)

        }
        buffaloButton.setOnClickListener {
            val itemName = "buffalo"
            val itemPrice = buffaloButton.text.toString()
            val itemImageResId = R.drawable.buffalo

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

        ranchButton.setOnClickListener {
            val itemName = "ranch"
            val itemPrice = ranchButton.text.toString()
            val itemImageResId = R.drawable.ranch

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
         * @return A new instance of fragment Sides.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Sides().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}