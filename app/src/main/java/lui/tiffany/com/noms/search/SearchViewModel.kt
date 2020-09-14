package lui.tiffany.com.noms.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.mapLatest
import lui.tiffany.com.noms.api.Recipe
import lui.tiffany.com.noms.api.RecipesRepository

class SearchViewModel @ViewModelInject constructor(
    recipesRepository: RecipesRepository
) : ViewModel() {

    val recipesUsingFlow: LiveData<List<RecipeRenderable>> = recipesRepository.getRecipes()
        .mapLatest { convert(it) }
        .asLiveData()

    fun convert(recipeResponse: List<Recipe>): List<RecipeRenderable> {
        return recipeResponse.map {
            RecipeRenderable(it.title)
        }
    }
}