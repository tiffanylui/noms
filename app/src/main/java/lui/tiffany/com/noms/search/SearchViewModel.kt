package lui.tiffany.com.noms.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import lui.tiffany.com.noms.api.Recipe
import lui.tiffany.com.noms.api.RecipesRepository

class SearchViewModel @ViewModelInject constructor(
    private val recipesRepository: RecipesRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    val recipeListRenderable: MutableLiveData<List<RecipeRenderable>> by lazy {
        MutableLiveData<List<RecipeRenderable>>()
    }

    init {
        recipesRepository.getRecipes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { convert(it) }
            .subscribe(
                { recipeListRenderable.postValue(it) },
                { Log.d("Error", it.message) }
            ).addTo(disposable)
    }

    fun convert(recipeResponse: List<Recipe>): List<RecipeRenderable> {
        return recipeResponse.map {
            RecipeRenderable(it.title)
        }
    }
}