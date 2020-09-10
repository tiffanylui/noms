package lui.tiffany.com.noms.search

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager

class SearchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<RecipeRenderable>()
    private val delegatesManager: AdapterDelegatesManager<List<RecipeRenderable>> =
        AdapterDelegatesManager()

    init {
        delegatesManager.addDelegate(SearchRecipeDelegate())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(items, position, holder)
    }

    fun setData(renderables: List<RecipeRenderable>) {
        items.clear()
        items.addAll(renderables)
        notifyDataSetChanged()
    }


}