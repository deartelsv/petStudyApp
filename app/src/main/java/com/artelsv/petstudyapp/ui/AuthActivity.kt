package com.artelsv.petstudyapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.artelsv.petstudyapp.App
import com.artelsv.petstudyapp.R
import com.artelsv.petstudyapp.databinding.ActivityAuthBinding
import com.artelsv.petstudyapp.di.factory.AuthViewModelFactory
import com.artelsv.petstudyapp.di.factory.MoviesViewModelFactory
import com.artelsv.petstudyapp.ui.utils.Screens
import com.artelsv.petstudyapp.ui.viewmodel.AuthViewModel
import com.artelsv.petstudyapp.ui.viewmodel.MoviesViewModel
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class AuthActivity : AppCompatActivity() {

    @Inject
    lateinit var authViewModelFactory: AuthViewModelFactory

    lateinit var viewModel: AuthViewModel

    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.instance.authComponent.inject(this)

        viewModel = ViewModelProvider(this, authViewModelFactory).get(AuthViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setNavigator(binding)
    }

    private fun setNavigator(binding: ActivityAuthBinding) {

//        App.instance.router.navigateTo(FragmentScreen {  })

        binding.btnA.setOnClickListener {
            Log.e("a", "a")

//            App.instance.authComponent.router().replaceScreen(Screens.main(this))
        }
    }

    override fun onStart() {
        super.onStart()

//        App.instance.authComponent.provideCicerone().getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()

//        App.instance.authComponent.provideCicerone().getNavigatorHolder().removeNavigator()
    }
}