package lui.tiffany.com.noms.api

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import lui.tiffany.com.noms.di.IoDispatcher
import javax.inject.Inject

interface RecipesRepository {
    fun getRecipes(): Flow<List<Recipe>>
}

class RecipesRepositoryImpl @Inject constructor(
    private val recipesApi: RecipesApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RecipesRepository {

    override fun getRecipes(): Flow<List<Recipe>> {
        return flow {
            val recipesResponse = recipesApi.getRecipes()
            emit(recipesResponse.results)
        }.flowOn(ioDispatcher)
    }
}