
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.FoodItem
import com.example.assignment1.R

class SelectedItemsAdapter(private val selectedItems: List<FoodItem>) : RecyclerView.Adapter<SelectedItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val selectedItem = selectedItems[position]
        holder.bind(selectedItem)
    }

    override fun getItemCount(): Int {
        return selectedItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(selectedItem: FoodItem) {
            // Bind the selected item data to the views in the ViewHolder
            itemView.findViewById<TextView>(R.id.itemName).text = selectedItem.name
//            itemView.findViewById<ImageView>(R.id.itemImage).setImageResource(selectedItem.image)
            itemView.findViewById<TextView>(R.id.itemPrice).text = selectedItem.price.toString()
        }
    }
}
