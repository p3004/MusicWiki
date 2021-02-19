package com.music.wiki.utils.common

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */

/**
 * Wrapper class for fetching data , to be used to control different states of data.
 * */

data class Resource<out T> private constructor(val status: Status , val data : T?,val msg : String?) {

    companion object{

        fun <T> loading( data : T?) : Resource<T> = Resource(Status.LOADING,null,null)

        fun <T> success(data : T?) : Resource<T> = Resource(Status.SUCCESS,data,null)

        fun <T> error(msg: String?) : Resource<T> = Resource(Status.ERROR,null,msg)

    }

}