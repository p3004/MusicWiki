package com.music.wiki.ui.genres.detail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.music.wiki.R
import kotlinx.android.synthetic.main.activity_genre_detail.*


class GenreDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre_detail)
        tvGenreInfo.movementMethod = ScrollingMovementMethod()
    }
}