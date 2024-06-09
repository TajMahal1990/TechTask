import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.techtask.Item
import com.example.techtask.ItemActivity
import com.example.techtask.R

class ItemsAdapter(var items: List<Item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image1: ImageButton = view.findViewById(R.id.item_list_image)
        val title1: TextView = view.findViewById(R.id.item_list_title)
        val price1: TextView = view.findViewById(R.id.item_list_price)

        val image2: ImageButton = view.findViewById(R.id.item_list_image_right)
        val title2: TextView = view.findViewById(R.id.item_list_title_right)
        val price2: TextView = view.findViewById(R.id.item_list_price_right)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return (items.size + 1) / 2
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemIndex1 = position * 2
        val itemIndex2 = position * 2 + 1

        // Заполняем первую колонку
        if (itemIndex1 < items.size) {
            holder.title1.text = items[itemIndex1].title
            holder.price1.text = items[itemIndex1].price.toString()

            val imageId1 = context.resources.getIdentifier(
                items[itemIndex1].image,
                "drawable",
                context.packageName
            )
            holder.image1.setImageResource(imageId1)

            holder.title1.setOnClickListener {
                val intent = Intent(context, ItemActivity::class.java)
                intent.putExtra("itemTitle", items[position].title)
                intent.putExtra("itemText", items[position].text)
                context.startActivity(intent)
            }
        } else {
            // Если в первой колонке не хватает элементов, скрываем видимость
            holder.title1.visibility = View.GONE
            holder.price1.visibility = View.GONE
            holder.image1.visibility = View.GONE
        }

        // Заполняем вторую колонку
        if (itemIndex2 < items.size) {
            holder.title2.text = items[itemIndex2].title
            holder.price2.text = items[itemIndex2].price.toString()

            val imageId2 = context.resources.getIdentifier(
                items[itemIndex2].image,
                "drawable",
                context.packageName
            )
            holder.image2.setImageResource(imageId2)
            holder.title2.setOnClickListener {
                val intent = Intent(context, ItemActivity::class.java)
                intent.putExtra("itemTitle", items[position].title)
                intent.putExtra("itemText", items[position].text)
                context.startActivity(intent)
            }
        } else {
            // Если во второй колонке не хватает элементов, скрываем видимость
            holder.title2.visibility = View.GONE
            holder.price2.visibility = View.GONE
            holder.image2.visibility = View.GONE
        }
    }

}




