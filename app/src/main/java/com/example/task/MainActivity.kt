package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.adapter.AutherListAdapter
import com.example.task.api.HitsService
import com.example.task.api.RetrofitHelper
import com.example.task.models.Hits
import com.example.task.repository.HitsRepository
import com.example.task.viewmodels.MainViewModel
import com.example.task.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerAdapter : AutherListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        val hitsService = RetrofitHelper.getInstance().create(HitsService::class.java)
        val repository = HitsRepository(hitsService)
        mainViewModel = ViewModelProvider(this , MainViewModelFactory(repository)).get(MainViewModel::class.java)


        mainViewModel.hits.observe(this , Observer{
           //Log.d("CODEDATA" , it.toString())
            if(it!=null){
                recyclerAdapter.setAuthorList(it.hits)
                recyclerAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this , "Error is getting" ,Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun initRecyclerView(){
        val recView = findViewById<RecyclerView>(R.id.recyclerViewLayout)
        recView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = AutherListAdapter()
        recView.adapter = recyclerAdapter
    }


}