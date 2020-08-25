package lui.tiffany.com.noms.common

import io.reactivex.Single
import retrofit2.HttpException
import retrofit2.Response

fun <T> Single<Response<T>>.extractBody(): Single<T> {
    return this.map {
        if (it.isSuccessful) {
            it.body()
        } else {
            throw HttpException(it)
        }
    }
}