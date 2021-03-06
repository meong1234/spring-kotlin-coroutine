/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.kotlin.experimental.coroutine.context

import io.reactivex.Scheduler as Rx2Scheduler
import io.reactivex.schedulers.Schedulers as Rx2Schedulers
import org.springframework.context.annotation.Bean
import reactor.core.scheduler.Scheduler as ReactorScheduler
import reactor.core.scheduler.Schedulers as ReactorSchedulers
import reactor.core.scheduler.TimedScheduler
import rx.Scheduler as Rx1Scheduler
import rx.schedulers.Schedulers as Rx1Schedulers

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ContextConfiguration {
    @Bean
    CustomContextService customContextService() {
        return new CustomContextService()
    }

    @Bean("ReactorScheduler")
    ReactorScheduler reactorScheduler() {
        return ReactorSchedulers.newSingle("ReactorSingleTest")
    }

    @Bean("ReactorTimedScheduler")
    TimedScheduler reactorTimedScheduler() {
        return ReactorSchedulers.newTimer("ReactorTimedSingleTest")
    }

    @Bean("Rx1IoScheduler")
    Rx1Scheduler rx1IoScheduler() {
        return Rx1Schedulers.io()
    }

    @Bean("Rx2IoScheduler")
    Rx2Scheduler rx2IoScheduler() {
        return Rx2Schedulers.io()
    }

    @Bean("SingleTestExecutor")
    Executor executor() {
        return Executors.newSingleThreadExecutor { runnable ->
            new Thread(runnable, "ExecutorSingleTest")
        }
    }
}
