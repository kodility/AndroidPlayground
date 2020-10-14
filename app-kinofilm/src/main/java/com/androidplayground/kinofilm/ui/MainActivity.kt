package com.androidplayground.kinofilm.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.androidplayground.coreandroid.activity.DataBindingActivity
import com.androidplayground.coreandroid.utils.ConnectionLiveData
import com.androidplayground.kinofilm.R
import com.androidplayground.kinofilm.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : DataBindingActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override val layoutResourceId = R.layout.activity_main

    override fun setInitialValues() {
        dataBinding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        ConnectionLiveData(getContext()).observe(getActivity()) { Timber.d("Network Connected: $it") }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
