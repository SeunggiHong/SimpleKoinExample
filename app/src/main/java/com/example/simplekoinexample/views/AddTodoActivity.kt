package com.example.simplekoinexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.simplekoinexample.utils.Constants.TAG
import com.example.simplekoinexample.R
import com.example.simplekoinexample.databinding.ActivityAddTodoBinding

class AddTodoActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_todo)
        Log.d(TAG, "AddTodoActivity - onCreate() called")
        title = "할 일 추가"

        initView()

        binding.btnTodoSave.setOnClickListener {
            Toast.makeText(this, "저장을 눌렀습니다..",Toast.LENGTH_SHORT).show()

            saveTodo()
        }
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_todo)
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AddTodoActivity - onStart() called") 
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "AddTodoActivity - onRestart() called") 
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AddTodoActivity - onResume() called") 
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AddTodoActivity - onPause() called") 
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AddTodoActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AddTodoActivity - onDestroy() called")
    }

    private fun saveTodo() {
        if (checkTodo()) {
            Log.d(TAG, "AddTodoActivity - saveTodo() checkTodo() is ${checkTodo()}")
        }
    }

    private fun checkTodo() : Boolean {
        if (binding.etTodoTitle.text.isNullOrEmpty()) {
            binding.tilTodoTitle.error = "제목을 입력해 주세요!!!"
            binding.etTodoTitle.requestFocus()
            return false
        }

        if (binding.etTodoContent.text.isEmpty()) {
            binding.etTodoContent.error = "내용을 입력해 주세요!!!"
            binding.etTodoContent.requestFocus()
            return false
        }

        return true
    }

}