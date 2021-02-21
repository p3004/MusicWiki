package com.music.wiki.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Singleton
import kotlin.reflect.KClass

/**
 * Created by Pallab Banerjee on 2/21/2021.
 */

/**
 *Used to create ViewModel instances with custom constructors
* */

@Singleton
class ViewModelProviderFactory<T : ViewModel>(

    private val kClass: KClass<T>,
    private val creator:() -> T

) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(kClass.java)) return creator() as T
        throw IllegalArgumentException("Unknown class name")
    }




}