package lui.tiffany.com.noms.search

import io.mockk.mockk
import lui.tiffany.com.noms.api.RecipesRepository
import lui.tiffany.com.noms.api.SearchConverter
import org.junit.Test

class SearchViewModelTest {

    private val repository = mockk<RecipesRepository>()
    private val searchConverter = mockk<SearchConverter>()
    val viewModel = SearchViewModel(repository, searchConverter)

    @Test
    fun `given repository emits recipe, data is converted to renderable`() {
//        every { repository.getRecipes() } returns
    }

}