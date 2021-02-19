package com.music.wiki.utils.rx

import io.reactivex.rxjava3.core.Scheduler

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */
interface SchedulerProvider {
    fun io() : Scheduler

    fun computation() : Scheduler

    fun ui() : Scheduler
}