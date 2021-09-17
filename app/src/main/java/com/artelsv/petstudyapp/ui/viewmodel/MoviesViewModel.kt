package com.artelsv.petstudyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artelsv.petstudyapp.data.model.Movie
import com.artelsv.petstudyapp.data.repository.MoviesRepositoryImpl
import io.reactivex.Single
import io.reactivex.SingleObserver
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
        val newSingle = moviesRepository.getNowPlayingMovies()
        val popularSingle = moviesRepository.getPopularMovies()

        Single.zip(newSingle, popularSingle, { new, popular ->
            moviesRepository.moviesDatabase.getMovieDao().addMovies(new.results)
            moviesRepository.moviesDatabase.getMovieDao().addMovies(popular.results)

            nowPlayingMovies.postValue(new.results.sortedBy { it.voteAverage })
            popularMovies.postValue(popular.results.sortedBy { it.voteAverage })

            return@zip 1
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(object : SingleObserver<Int> {
            override fun onSubscribe(d: Disposable) {

            }


            override fun onError(e: Throwable) {
                loading.postValue(false)
            }

            override fun onSuccess(t: Int) {
                loading.postValue(false)
            }
        })
    }
}