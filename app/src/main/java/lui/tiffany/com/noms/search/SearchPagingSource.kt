package lui.tiffany.com.noms.search

import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import lui.tiffany.com.noms.api.Recipe
import lui.tiffany.com.noms.api.RecipesApi
import lui.tiffany.com.noms.api.RecipesResponse
import lui.tiffany.com.noms.common.extractBody

class SearchPagingSource(
    private val recipesApi: RecipesApi
) : RxPagingSource<Int, Recipe>() {
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Recipe>> {
        val position = params.key ?: 1

        return recipesApi.getRecipes()
            .subscribeOn(Schedulers.io())
            .extractBody()
            .map { loadResult(it, position) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    fun loadResult(
        response: RecipesResponse,
        position: Int
    ): LoadResult<Int, Recipe> {
        val lastKey = Math.floor((response.totalResults / response.number).toDouble()).toInt()
        return LoadResult.Page(
            data = response.results,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position == lastKey) null else position + 1
        )
    }


}