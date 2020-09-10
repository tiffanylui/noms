package lui.tiffany.com.noms.api

import io.reactivex.Single
import lui.tiffany.com.noms.common.extractBody
import javax.inject.Inject

interface RecipesRepository {
    fun getRecipes(): Single<List<Recipe>>
}

class RecipesRepositoryImpl @Inject constructor(
    private val recipesApi: RecipesApi
) : RecipesRepository {
    override fun getRecipes(): Single<List<Recipe>> {
        return recipesApi.getRecipes()
            .extractBody()
            .map { it.results }
    }

}

