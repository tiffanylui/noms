package lui.tiffany.com.noms.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface RecipesRepository {
    fun getRecipes(): Flow<List<Recipe>>
}

class RecipesRepositoryImpl @Inject constructor(
    private val recipesApi: RecipesApi,
    private val dispatchers: Dispatchers
) : RecipesRepository {

    override fun getRecipes(): Flow<List<Recipe>> {
        return flow {
            val recipesResponse = recipesApi.getRecipes().results
            emit(recipesResponse)
        }.flowOn(dispatchers.Default)
    }

}

