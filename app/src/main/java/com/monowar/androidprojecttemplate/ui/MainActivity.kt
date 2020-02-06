package com.monowar.androidprojecttemplate.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.monowar.androidprojecttemplate.R
import com.monowar.androidprojecttemplate.databinding.ActivityMainBinding
import com.monowar.libbase.activity.MVVMDataBindingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MVVMDataBindingActivity<MainViewModel, ActivityMainBinding>() {

    override val vmClass = MainViewModel::class.java

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
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
