package com.example.simplekoinexample

class KoinPresenter(private val repo: KoinRepository){
    fun sayMyName() = "${repo.giveName()} from $this"
}