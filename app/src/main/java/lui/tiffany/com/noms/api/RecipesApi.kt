package lui.tiffany.com.noms.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface RecipesApi {
    @GET("/recipes/complexSearch?apiKey=4d07076bcdc04d5ba950ab7ec66ddc7b")
    fun getRecipes(): Single<Response<RecipesResponse>>
}
