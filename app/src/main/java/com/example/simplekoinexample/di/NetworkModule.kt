package com.example.simplekoinexample.di

import com.example.simplekoinexample.models.api.RxSingleSchedulers
import com.example.simplekoinexample.createBasicAuthService
import org.koin.dsl.module

val networkModule = module {
    single { createBasicAuthService() }
    single { RxSingleSchedulers.DEFAULT}
}