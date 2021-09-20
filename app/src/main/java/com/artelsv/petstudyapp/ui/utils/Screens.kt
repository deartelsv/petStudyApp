package com.artelsv.petstudyapp.ui.utils

import android.content.Intent
import android.net.Uri
import com.artelsv.petstudyapp.ui.AuthActivity
import com.artelsv.petstudyapp.ui.MainActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen

object Screens {
    fun main(authActivity: AuthActivity) = ActivityScreen{ Intent(authActivity, MainActivity::class.java) }
    fun Browser(url: String) = ActivityScreen { Intent(Intent.ACTION_VIEW, Uri.parse(url))  }
}