package lui.tiffany.com.noms.api

import retrofit2.http.GET

interface RecipesApi {
    @GET("/recipes/complexSearch?apiKey=4d07076bcdc04d5ba950ab7ec66ddc7b")
    suspend fun getRecipes(): RecipesResponse
}
