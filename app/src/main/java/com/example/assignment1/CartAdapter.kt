import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.FoodItem
import com.example.assignment1.R

class CartAdapter(private val foodItemList: List<FoodItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodName: TextView = itemView.findViewById(R.id.item1NameTextView)
        val foodImage: ImageView = itemView.findViewById(R.id.item1ImageView)
        val foodPrice: TextView = itemView.findViewById(R.id.item1PriceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cart, parent, false)
        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val foodItem = foodItemList[position]
        holder.foodName.text = foodItem.name
        holder.foodImage.setImageResource(foodItem.imageResId)
        holder.foodPrice.text = "$" + foodItem.price.toString()
    }

    override fun getItemCount(): Int {
        return foodItemList.size
    }
}
