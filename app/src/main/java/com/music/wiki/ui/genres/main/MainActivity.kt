package com.music.wiki.ui.genres.main

import android.net.wifi.aware.WifiAwareManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.music.wiki.R
import com.music.wiki.WikiApplication
import com.music.wiki.di.components.ApplicationComponent
import com.music.wiki.di.components.DaggerActivityComponent
import com.music.wiki.di.modules.ActivityModule
import com.music.wiki.utils.common.Status
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var topGenreAdapter: TopGenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        injectBuilder()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getTopGenreFromApi()
        setObservers()
    }

    private fun injectBuilder() {

        DaggerActivityComponent.builder()
            .applicationComponent((application as WikiApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)

    }


    private fun setObservers() {

        mainViewModel.topGenreListLiveData.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    pbMain.visibility = View.VISIBLE
                    rvGenre.visibility = View.GONE
                }

                Status.SUCCESS -> {
                    rvGenre.visibility = View.VISIBLE
                    pbMain.visibility = View.GONE
                    topGenreAdapter.submitList(it.data?.toptags?.tag)
                    rvGenre.apply {
                        adapter = topGenreAdapter
                    }

                }
                Status.ERROR -> {
                    pbMain.visibility = View.GONE
                    rvGenre.visibility = View.GONE
                    val snackbar = Snackbar.make(clMainParent, it.msg.toString(),Snackbar.LENGTH_LONG)
                    snackbar.setAction("retry!") {
                        mainViewModel.getTopGenreFromApi()
                    }
                    snackbar.show()
                }


            }


        })


    }


}