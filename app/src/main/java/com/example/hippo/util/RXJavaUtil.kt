package com.example.hippo.util

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

// Set of utility extensions that allows us to more easily subscribe to RXJava

fun Completable.subscribeIoObserveMain() = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.subscribeIoObserveMain() = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())!!

fun <T> Observable<T>.subscribeIoObserveMain() = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())!!

fun <T> Single<T>.subscribeIoObserveMain() = this
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())!!