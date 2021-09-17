package com.artelsv.petstudyapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artelsv.petstudyapp.App
import com.artelsv.petstudyapp.data.model.Movie
import com.artelsv.petstudyapp.databinding.ActivityMainBinding
import com.artelsv.petstudyapp.di.factory.MoviesViewModelFactory
import com.artelsv.petstudyapp.ui.viewmodel.MoviesViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var moviesViewModelFactory: MoviesViewModelFactory

    lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.instance.moviesComponent.inject(this)

        viewModel = ViewModelProvider(this, moviesViewModelFactory).get(MoviesViewModel::class.java)

        setObservers(binding)
    }

    private fun setObservers(binding: ActivityMainBinding) {
        viewModel.localMovies.observe(this, {
            if (!it.isNullOrEmpty()) {
                setMoviesRv(binding, it)
            }
        })
    }

    private fun setMoviesRv(binding: ActivityMainBinding, data: List<Movie>) {
        binding.rvMovies.adapter = MovieAdapter(MovieAdapter.OnClickListener {

        })

        binding.rvMovies.layoutManager = LinearLayoutManager(this)

        (binding.rvMovies.adapter as MovieAdapter).data = data
    }
}