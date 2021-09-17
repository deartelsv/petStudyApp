package com.artelsv.petstudyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artelsv.petstudyapp.data.model.Movie
import com.artelsv.petstudyapp.data.network.model.MovieResponse
import com.artelsv.petstudyapp.data.repository.MoviesRepositoryImpl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel(private val moviesRepository: MoviesRepositoryImpl) : ViewModel() {

    val localMovies = MutableLiveData<List<Movie>>(null)

    val loading = MutableLiveData(false)

    init {
        getMovies()
    }

    private fun getMovies() {
        moviesRepository.getMovies().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object : SingleObserver<MovieResponse> {
                override fun onSubscribe(d: Disposable) {
                    loading.postValue(true)
                }

                override fun onSuccess(t: MovieResponse) {
                    val data = t.results
                    moviesRepository.moviesDatabase.getMovieDao().addMovies(data)

//                    localMovies.postValue(moviesRepository.moviesDatabase.getMovieDao().getAllMoviesSortedByVote()) // зачем делать лишний запрос в бд? хм
                    localMovies.postValue(data.sortedBy { it.voteAverage })

                    loading.postValue(false)
                }

                override fun onError(e: Throwable) {
                    loading.postValue(false)
                }
            })
    }
}