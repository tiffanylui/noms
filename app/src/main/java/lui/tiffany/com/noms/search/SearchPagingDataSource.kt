package lui.tiffany.com.noms.search

import androidx.paging.PagingSource
import lui.tiffany.com.noms.api.RecipesApi
import lui.tiffany.com.noms.api.RecipesResponse
import javax.inject.Inject

class SearchPagingDataSource @Inject constructor(
    private val recipesApi: RecipesApi
) : PagingSource<Int, RecipesResponse>() {

    companion object {
        private const val OFFSET = 10
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipesResponse> {
        TODO("Not yet implemented")
    }

}