package com.example.simplekoinexample

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //싱글톤 인스턴스
    single<KoinRepository> {
        KoinRepositoryImpl()
    }

    //인스턴스 매번 생성
    //의존성 주입이 일어날때마다 객체 생성
    //get() 함수를 호출하면 타입추론을 통해 생성된 객체를 참조
    factory {
        KoinPresenter(get())
    }

}

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
}