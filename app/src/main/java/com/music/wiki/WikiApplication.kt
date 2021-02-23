package com.music.wiki

import android.app.Application
import com.music.wiki.di.components.ApplicationComponent
import com.music.wiki.di.components.DaggerApplicationComponent
import com.music.wiki.di.modules.ApplicationModule

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */

/**
 * [WikiApplication] class created by extending Application class
 * to help build the singleton dependencies via dagger.
 **/

class WikiApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    // replace the component with a test specific one
    fun setApplicationComponentForTest(applicationComponent: ApplicationComponent) {
        this.applicationComponent = applicationComponent
    }

}