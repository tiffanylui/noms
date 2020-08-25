package lui.tiffany.com.noms

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.search_fragment.*

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.search_fragment) {

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recipeNameObserver = Observer<String> {
            recipe.text = it
        }

        viewModel.recipeName.observe(this, recipeNameObserver)
    }
}