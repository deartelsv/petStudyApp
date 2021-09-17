package com.artelsv.petstudyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artelsv.petstudyapp.data.model.Movie
import com.artelsv.petstudyapp.data.network.model.MovieResponse
import com.artelsv.petstudyapp.data.repository.MoviesRepositoryImpl
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(private val moviesRepository: MoviesRepositoryImpl) : ViewModel() {

    val popularMovies = MutableLiveData<List<Movie>>(listOf())
    val nowPlayingMovies = MutableLiveData<List<Movie>>(listOf())

    val loading = MutableLiveData(false)

    init {
        loading.postValue(true)
        getPopularMovies()
        getMoviesNowPlaying()
    }

    private fun getPopularMovies() {
        moviesRepository.getPopularMovies().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object : SingleObserver<MovieResponse> {
                override fun onSubscribe(d: Disposable) {
//                    loading.postValue(true)
                }

                override fun onSuccess(t: MovieResponse) {
                    val data = t.results
                    moviesRepository.moviesDatabase.getMovieDao().addMovies(data)

                    popularMovies.postValue(data.sortedBy { it.voteAverage })

                    popularMovies.value.isNullOrEmpty()

                    loading.postValue(!popularMovies.value.isNullOrEmpty() && !nowPlayingMovies.value.isNullOrEmpty())
                }

                override fun onError(e: Throwable) {
//                    loading.postValue(false)
                }
            })
    }

    private fun getMoviesNowPlaying() {
        moviesRepository.getNowPlayingMovies().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object : SingleObserver<MovieResponse> {
                override fun onSubscribe(d: Disposable) {
//                    loading.postValue(true)
                }

                override fun onSuccess(t: MovieResponse) {
                    val data = t.results
                    moviesRepository.moviesDatabase.getMovieDao().addMovies(data)

                    nowPlayingMovies.postValue(data.sortedBy { it.voteAverage })

                    loading.postValue(!popularMovies.value.isNullOrEmpty() && !nowPlayingMovies.value.isNullOrEmpty())
                }

                override fun onError(e: Throwable) {
//                    loading.postValue(false)
                }
            })
    }
}