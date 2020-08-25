package lui.tiffany.com.noms

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import lui.tiffany.com.noms.api.RecipesRepository
import lui.tiffany.com.noms.common.plusAssign

class SearchViewModel @ViewModelInject constructor(
    recipesRepository: RecipesRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    val recipeName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        disposable += recipesRepository.getRecipes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { recipeName.postValue(it.first().title) },
                { Log.d("hello", it.message) }
            )
    }
}