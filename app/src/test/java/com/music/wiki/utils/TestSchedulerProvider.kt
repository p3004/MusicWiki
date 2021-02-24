package com.music.wiki.utils

import com.music.wiki.utils.rx.SchedulerProvider
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.TestScheduler

/**
 * Created by Pallab Banerjee on 2/21/2021.
 */

/**
 * Scheduler provider for unit testing
 * */
class TestSchedulerProvider(private val testScheduler: TestScheduler) : SchedulerProvider {

    override fun io(): Scheduler = testScheduler

    override fun computation(): Scheduler = testScheduler

    override fun ui(): Scheduler = testScheduler
}