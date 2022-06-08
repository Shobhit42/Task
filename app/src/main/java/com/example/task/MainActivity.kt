package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.task.api.HitsService
import com.example.task.api.RetrofitHelper
import com.example.task.repository.HitsRepository
import com.example.task.viewmodels.MainViewModel
import com.example.task.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var hello : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello.findViewById<TextView>(R.id.hello)

        val hitsService = RetrofitHelper.getInstance().create(HitsService::class.java)
        val repository = HitsRepository(hitsService)
        mainViewModel = ViewModelProvider(this , MainViewModelFactory(repository)).get(MainViewModel::class.java)

        var flage :Boolean = false;
        mainViewModel.hits.observe(this , Observer{
            Log.d("CODEDATA" , it.hits.toString())
            hello.setText(it.hits.toString())
            flage = true
        })
        if(!flage){
            hello.setText("hello")
        }



    }
}