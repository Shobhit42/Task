package com.example.task.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.task.api.HitsService
import com.example.task.models.FirstHits

class HitsRepository(private val hitsService: HitsService) {

    private val hitsLiveData = MutableLiveData<FirstHits>()
    val hits : LiveData<FirstHits>

    get() = hitsLiveData

    suspend fun getHits(page: Int){
        val result = hitsService.getHits(page)
        if(result?.body() != null){
            hitsLiveData.postValue(result.body())
        }
    }
}