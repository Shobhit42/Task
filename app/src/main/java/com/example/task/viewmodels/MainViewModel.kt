package com.example.task.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.models.FirstHits
import com.example.task.repository.HitsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: HitsRepository) : ViewModel(){
    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getHits(1)
        }
    }

    val hits : LiveData<FirstHits>
    get() = repository.hits
}