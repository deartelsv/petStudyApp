package com.artelsv.petstudyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artelsv.petstudyapp.data.entity.MovieEntity
import com.artelsv.petstudyapp.domain.MoviesRepository
import com.artelsv.petstudyapp.domain.model.Movie
import com.artelsv.petstudyapp.domain.model.MovieType
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(private val moviesRepository: MoviesRepositoryImpl) : ViewModel() {

    val popularMovies = MutableLiveData<List<Movie>>(listOf())
    val nowPlayingMovies = MutableLiveData<List<Movie>>(listOf())

    val loading = MutableLiveData(true)

    init {
        getMovies()
    }

    private fun getMovies() {
        val popularSingle = moviesRepository.getPopularMovies()
        val newSingle = moviesRepository.getNowPlayingMovies()

        Single.zip(newSingle, popularSingle, { new, popular ->
            /**
             * "Сортировка" по категориям
             **/
            val sorted = arrayListOf<Pair<MovieType, List<Movie>>>()

            sorted.add(Pair(MovieType.NOW_PLAYING, new.results))
            sorted.add(Pair(MovieType.POPULAR, popular.results))

            return@zip sorted.toList()
        })
            .subscribeOn(Schedulers.io()) // TODO вот эти две штуки особо выжные, они отвечают за то, в каком потоке будет происходить обработка данных
            .observeOn(Schedulers.io())  // TODO обзательно посомтри вот это https://proandroiddev.com/understanding-rxjava-subscribeon-and-observeon-744b0c6a41ea
            .subscribe(object : SingleObserver<List<Pair<MovieType, List<Movie>>>> { // боже, какой монстр получился
                override fun onSubscribe(d: Disposable) {

                }

                override fun onSuccess(t: List<Pair<MovieType, List<Movie>>>) {
                    /**
                     * У меня тут 2 категории разные, и они в разных лайвдате лежат, не придумал способа лучше для разделения (опираюсь на тудушку выше, что работа должна проиходить здесь)
                     **/
                    for (item in t) {
                        when(item.first) {
                            MovieType.POPULAR -> mPopularMovies.postValue(item.second)
                            MovieType.NOW_PLAYING -> mNowPlayingMovies.postValue(item.second)
                        }
                    }

                    loading.postValue(false)
                }

                override fun onError(e: Throwable) {
                    // предположим шо тут обработка ошибки
                    loading.postValue(false)
                }

            })

    }
}