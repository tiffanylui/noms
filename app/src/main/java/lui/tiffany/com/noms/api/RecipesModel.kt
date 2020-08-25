package lui.tiffany.com.noms.api

data class RecipesResponse(
    val results: List<Recipes>,
    val offset: Int,
    val number: Int,
    val totalResults: Int
)

data class Recipes(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)