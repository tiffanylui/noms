package lui.tiffany.com.noms.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.mapLatest
import lui.tiffany.com.noms.api.RecipesRepository
import lui.tiffany.com.noms.api.SearchConverter

class SearchViewModel @ViewModelInject constructor(
    recipesRepository: RecipesRepository,
    converter: SearchConverter
) : ViewModel() {

    val recipesUsingFlow: LiveData<List<RecipeRenderable>> = recipesRepository.getRecipes()
        .mapLatest { converter.convert(it) }
        .asLiveData()
}