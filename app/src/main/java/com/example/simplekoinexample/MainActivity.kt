package com.example.simplekoinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.simplekoinexample.Constants.TAG
import com.example.simplekoinexample.recyclerview.TodoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var todoAdapter: TodoAdapter
    private val namePresenter: KoinPresenter by inject()
    val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")

        tv_name_view.text = namePresenter.sayMyName()

        initView()
        setObserveView()
    }

    private fun initView() {
        todoAdapter = TodoAdapter()
        rc_todo_view.adapter = todoAdapter

        mainViewModel.todoList.observe(this, Observer {
            it.let {
                todoAdapter.setItems(it)
            }
        })

        mainViewModel.fetchTodo()

    }

    private fun setObserveView() {

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity - onPause() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy() called")
    }
}