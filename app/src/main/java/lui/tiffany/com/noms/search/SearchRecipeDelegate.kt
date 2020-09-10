package lui.tiffany.com.noms.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.synthetic.main.item_search_recipe.view.*
import lui.tiffany.com.noms.R

class SearchRecipeDelegate : AdapterDelegate<List<RecipeRenderable>>() {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_search_recipe, parent, false)
        return Holder(view)
    }

    override fun isForViewType(items: List<RecipeRenderable>, position: Int): Boolean = true
    override fun onBindViewHolder(
        items: List<RecipeRenderable>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val item = items[position]
        val viewHolder = holder as Holder

        with(viewHolder.itemView) {
            title.text = item.title
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

}

class RecipeRenderable(
    val title: String
)