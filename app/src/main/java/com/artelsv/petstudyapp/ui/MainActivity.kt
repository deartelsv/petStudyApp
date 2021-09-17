package com.artelsv.petstudyapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artelsv.petstudyapp.App
import com.artelsv.petstudyapp.R
import com.artelsv.petstudyapp.data.model.Movie
import com.artelsv.petstudyapp.databinding.ActivityMainBinding
import com.artelsv.petstudyapp.di.factory.MoviesViewModelFactory
import com.artelsv.petstudyapp.ui.utils.HorizontalMarginItemDecoration
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
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

//        App.instance.navigatorHolder.setNavigator(navigator)
//        App.instance.router.navigateTo(FragmentScreen {  })

        setObservers(binding)
    }

    private fun setObservers(binding: ActivityMainBinding) {
        viewModel.popularMovies.observe(this, {
            if (!it.isNullOrEmpty()) {
                setMoviesPopularRv(binding, it)
            }
        })

        viewModel.nowPlayingMovies.observe(this, {
            if (!it.isNullOrEmpty()) {
                setMoviesNowPlayingRv(binding, it)
            }
        })
    }

    private fun setMoviesNowPlayingRv(binding: ActivityMainBinding, data: List<Movie>) {
        binding.rvMoviesNowPlaying.adapter = MovieAdapter(MovieAdapter.OnClickListener {

        })

        binding.rvMoviesNowPlaying.layoutManager = LinearLayoutManager(this)

        (binding.rvMoviesNowPlaying.adapter as MovieAdapter).data = data

        binding.rvMoviesNowPlaying.addItemDecoration(
            HorizontalMarginItemDecoration(
                this,
                R.dimen.viewpager_current_item_horizontal_margin,
                horizontal = false)
        )
    }

    private fun setMoviesPopularRv(binding: ActivityMainBinding, data: List<Movie>) {
        binding.rvMoviesPopular.adapter = MovieAdapter(MovieAdapter.OnClickListener {

        })

        binding.rvMoviesPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        (binding.rvMoviesPopular.adapter as MovieAdapter).data = data

        binding.rvMoviesPopular.addItemDecoration(
            HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin)
        )
    }
}