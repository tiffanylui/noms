package lui.tiffany.com.noms.api

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Test

class RecipesRepositoryTest {
    private val testDispatcher = TestCoroutineDispatcher()

    private val recipe = Recipe(
        id = 0,
        title = "Recipe Title",
        image = "image.url",
        imageType = "jpeg"
    )

    @Test
    fun `should get recipes`() = runBlocking {
        val recipesResponse = RecipesResponse(
            results = listOf(recipe),
            offset = 0,
            number = 0,
            totalResults = 50
        )

        val recipesApi = mock<RecipesApi>() {
            onBlocking { getRecipes() } doReturn recipesResponse
        }

        val repository = RecipesRepositoryImpl(recipesApi, testDispatcher)

        val flow: Flow<List<Recipe>> = repository.getRecipes()
        flow.collect {
            assertEquals(listOf(recipe), it)
        }

    }
}