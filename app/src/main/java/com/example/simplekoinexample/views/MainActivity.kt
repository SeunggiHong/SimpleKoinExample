package com.example.simplekoinexample.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.simplekoinexample.Constants.TAG
import com.example.simplekoinexample.KoinPresenter
import com.example.simplekoinexample.MainViewModel
import com.example.simplekoinexample.R
import com.example.simplekoinexample.databinding.ActivityMainBinding
import com.example.simplekoinexample.recyclerview.TodoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val namePresenter: KoinPresenter by inject()
    private val mainViewModel: MainViewModel by viewModel()
    lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")

        initView()
        initAdapter()
        initViewModel()

        binding.fabNewTodo.setOnClickListener {
            val intent = Intent(this, AddTodoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.tvNameView.text = namePresenter.sayMyName()
    }

    private fun initAdapter() {
        todoAdapter = TodoAdapter()
        rc_todo_view.adapter = todoAdapter
    }

    private fun initViewModel() {
        mainViewModel.todoList.observe(this, Observer {
            it.let {
                todoAdapter.setItems(it)
            }
        })
        mainViewModel.fetchTodo()

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called") 
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity - onRestart() called") 
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity - onStop() called") 
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy() called")
    }
}