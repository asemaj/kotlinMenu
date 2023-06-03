package com.example.assignment1

import SelectedItemsAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



interface OnItemSelectionListener {
    fun onItemSelected(item: FoodItem)
}


class FoodFragment : Fragment(), OnItemSelectionListener {
    private lateinit var cartActivityResultLauncher: ActivityResultLauncher<Intent>
    private var listener: OnItemSelectionListener? = null

    val itemList = mutableListOf<FoodItem>()

    private val foodItemList = mutableListOf<FoodItem>()
    private val selectedFoodItems = mutableListOf<FoodItem>()


    private lateinit var steakImageView: ImageView
    private lateinit var steakDescriptionTextView: TextView
    private lateinit var steakButton: Button

    private lateinit var lasagnaButton: Button
    private lateinit var lasagnaImageView: ImageView
    private lateinit var lasagnaDescriptionTextView: TextView

    private lateinit var meatballsButton: Button
    private lateinit var meatballsImageView: ImageView
    private lateinit var meatballsDescriptionTextView: TextView

    private lateinit var tacosButton: Button
    private lateinit var tacosImageView: ImageView
    private lateinit var tacosDescriptionTextView: TextView

    private lateinit var bakedPotatoButton: Button
    private lateinit var bakedPotatoImageView: ImageView
    private lateinit var bakedPotatoDescriptionTextView: TextView

    private fun setupRecyclerView() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = SelectedItemsAdapter(selectedFoodItems)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter
    }
    private fun onRadioButtonChecked(item: FoodItem) {
        val selectedFood = getSelectedFood()
        selectedFood?.let {
            listener?.onItemSelected(item)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_food, container, false)


        foodItemList.add(FoodItem( "Steak",R.drawable.stake,22.00))
        foodItemList.add(FoodItem( "lasagna",R.drawable.lasagna, 10.00))
        foodItemList.add(FoodItem("MeatBalls", R.drawable.meatball, 8.00))
        foodItemList.add(FoodItem( "Baked Potato",R.drawable.potato,6.5))
        foodItemList.add(FoodItem("Tacos", R.drawable.taco,9.0))

//        val radioGroup = view.findViewById<RadioGroup>(R.id.steakRadiogroup)
//        for (foodItem in foodItemList) {
//            val radioButton = RadioButton(requireContext())
//            radioButton.text = foodItem.name
//            radioButton.tag = foodItem
//            radioGroup.addView(radioButton)
//        }
//
//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            val radioButton = group.findViewById<RadioButton>(checkedId)
//            val selectedFoodItem = radioButton?.tag as? FoodItem
//            selectedFoodItem?.let {
//                if (radioButton.isChecked) {
//                    selectedFoodItems.add(it)
//                } else {
//                    selectedFoodItems.remove(it)
//                }
//            }
//        }


        return view






//        cartActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val data: Intent? = result.data
//                val selectedItem = data?.getParcelableExtra<Item>("selectedItem")
//                selectedItem?.let { onItemSelected(it) }
//            }
//        }
//
//        // Rest of the fragment code
//
//        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val cartImageView = requireActivity().findViewById<ImageView>(R.id.cartBtn)

        val intent = Intent(requireContext(), CartActivity::class.java)

        steakImageView = view.findViewById(R.id.stake)
        steakDescriptionTextView = view.findViewById(R.id.stakeDescription)
        steakButton = view.findViewById(R.id.stakeBtn)

        lasagnaImageView = view.findViewById(R.id.lasagna)
        lasagnaDescriptionTextView = view.findViewById(R.id.lasagnaDescription)
        lasagnaButton = view.findViewById(R.id.lasagnaBtn)

        meatballsImageView = view.findViewById(R.id.meatball)
        meatballsDescriptionTextView = view.findViewById(R.id.meatballDescription)
        meatballsButton = view.findViewById(R.id.meatballsBtn)

        tacosImageView = view.findViewById(R.id.taco)
        tacosDescriptionTextView = view.findViewById(R.id.tacoDescription)
        tacosButton = view.findViewById(R.id.tacosBtn)

        bakedPotatoImageView = view.findViewById(R.id.imageView)
        bakedPotatoDescriptionTextView = view.findViewById(R.id.textView31)
        bakedPotatoButton = view.findViewById(R.id.bakedpotatoBtn)



        steakButton.setOnClickListener {
            val itemName = "Steak"
            val itemPrice = steakButton.text.toString()
            val itemImageResId = R.drawable.stake

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

        lasagnaButton.setOnClickListener {
            val itemName = "lasagna"
            val itemPrice = lasagnaButton.text.toString()
            val itemImageResId = R.drawable.lasagna

            intent.putExtra("itemName", itemName)
            intent.putExtra("itemPrice", itemPrice)
            intent.putExtra("itemImageResId", itemImageResId)

        }
        meatballsButton.setOnClickListener {
            val itemName = "meatballs"
            val itemPrice = meatballsButton.text.toString()
            val itemImageResId = R.drawable.meatball

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

        tacosButton.setOnClickListener {
            val itemName = "taco"
            val itemPrice = tacosButton.text.toString()
            val itemImageResId = R.drawable.taco

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

        bakedPotatoButton.setOnClickListener {
            val itemName = "baked potato"
            val itemPrice = bakedPotatoButton.text.toString()
            val itemImageResId = R.drawable.potato

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

    override fun onItemSelected(item: FoodItem) {
        val cartIntent = Intent(requireContext(), CartActivity::class.java)
        val selectedItems = arrayListOf(item) // Create an ArrayList with the selected item
        cartIntent.putExtra("selectedItems", selectedItems) // Pass the ArrayList to the CartActivity
        cartActivityResultLauncher.launch(cartIntent)
    }




//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
//
//        val view = inflater.inflate(R.layout.fragment_food, container, false)
//
//        cartActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val data: Intent? = result.data
//                val selectedItems = data?.getParcelableArrayListExtra<Item>("selectedItems")
//            }
//        }
//        return view
//
////        var steakBtn: RadioButton? = view?.findViewById(R.id.steak)
////        var lasagnaBtn: RadioButton? = view?.findViewById(R.id.radioButton3)
////        var meatBallsBtn: RadioButton? = view?.findViewById(R.id.meatballs)
////        var bakedPotatoBtn: RadioButton? = view?.findViewById(R.id.bakedpotato)
////        var tacosBtn: RadioButton? = view?.findViewById(R.id.tacos)
//
////        return inflater.inflate(R.layout.fragment_food, container, false)
//    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnItemSelectionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnItemSelectionListener")
        }
    }

    private fun onRadioButtonIsChecked(item: FoodItem) {
        listener?.onItemSelected(item)
    }



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var steakBtn: RadioButton
    private lateinit var lasagnaBtn: RadioButton
    private lateinit var meatBallsBtn: RadioButton
    private lateinit var bakedPotatoBtn: RadioButton
    private lateinit var tacosBtn: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var steakBtn1: Button? = view?.findViewById(R.id.stakeBtn)
        var lasagnaBtn1: RadioButton? = view?.findViewById(R.id.lasagna)
//        var meatBallsBtn1: RadioButton? = view?.findViewById(R.id.meatballs2)
//        var bakedPotatoBtn1: RadioButton? = view?.findViewById(R.id.bakedpotato)
//        var tacosBtn1: RadioButton? = view?.findViewById(R.id.tacos2)


        if (steakBtn1 != null) {
            steakBtn1.setOnClickListener {
                val itemName = "Stake"
                val itemPrice = steakButton.text.toString()
                val itemImageResId = R.drawable.stake

                val intent = Intent(requireContext(), CartActivity::class.java)
                intent.putExtra("itemName", itemName)
                intent.putExtra("itemPrice", itemPrice)
                intent.putExtra("itemImageResId", itemImageResId)
                startActivity(intent)
            }
        }

//        steakBtn1?.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                val newItem = FoodItem( "Steak",R.drawable.stake, 22.0)
//                onRadioButtonChecked(newItem)
//            } else {
//            }
//        }

        lasagnaBtn1?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val newItem = FoodItem( "Lasagna",R.drawable.lasagna, 10.0)
                onRadioButtonChecked(newItem)
            } else {
            }
        }

//        meatBallsBtn1?.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                val newItem = FoodItem("Steak",R.drawable.stake,  22.0)
//                onRadioButtonChecked(newItem)
//            } else {
//            }
//        }
//
//        bakedPotatoBtn1?.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                val newItem = FoodItem( "Lasagna", R.drawable.lasagna,10.0)
//                onRadioButtonChecked(newItem)
//            } else {
//            }
//        }
//        tacosBtn1?.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                val newItem = FoodItem( "Lasagna",R.drawable.lasagna, 10.0)
//                onRadioButtonChecked(newItem)
//            } else {
//            }
//        }

//        if (steakBtn1 != null) {
//            steakBtn1.setOnCheckedChangeListener{_,isChecked ->
//                if(isChecked){
//                    val newItem = Item(R.drawable.stake, "steak", 22.0)
//                    itemList.add(newItem)
//                } else {
//                    val itemRemove = Item(R.drawable.stake, "steak", 22.0)
//                    itemList.remove(itemRemove)
//                }
//
//            }
//        }
    }

    private fun <T> ArrayAdapter(
        context: Context,
        simpleListItem1: Int,
        foodVal: Array<T>
    ): SpinnerAdapter? {
        TODO("Not yet implemented")
    }


    fun getSelectedFood(): Item?{

        return when{
            steakBtn.isChecked -> Item( "Steak",22.00,R.drawable.stake)
            lasagnaBtn.isChecked -> Item( "lasagna", 10.00,R.drawable.lasagna)
            meatBallsBtn.isChecked -> Item( "MeatBalls", 8.00,R.drawable.meatball)
            bakedPotatoBtn.isChecked -> Item("Baked Potato",6.5, R.drawable.potato)
            tacosBtn.isSelected -> Item("Tacos", 9.0,R.drawable.taco)
            else -> null
        }
    }




    companion object {

        private const val REQUEST_CART = 1

    }
}


