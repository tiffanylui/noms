package lui.tiffany.com.noms.api

import lui.tiffany.com.noms.search.RecipeRenderable
import javax.inject.Inject

class SearchConverter @Inject constructor() {

    fun convert(recipeResponse: List<Recipe>): List<RecipeRenderable> {
        return recipeResponse.map {
            RecipeRenderable(it.title)
        }
    }

}