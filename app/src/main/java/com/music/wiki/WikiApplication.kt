package com.music.wiki

import android.app.Application

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */

/**
 * [WikiApplication] class created by extending Application class
 * to help build the singleton dependencies via dagger.
 **/

class WikiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}