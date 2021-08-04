package com.example.simplekoinexample

import com.example.simplekoinexample.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val viewModelModule = module {
    viewModel {
        MainViewModel(androidApplication(), get(), get())
    }
}

val databaseModule = module {
    single {

    }
}