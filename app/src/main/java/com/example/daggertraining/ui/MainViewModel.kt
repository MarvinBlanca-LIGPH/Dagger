package com.example.daggertraining.ui

import androidx.lifecycle.*
import com.example.daggertraining.data.Heroes
import com.example.daggertraining.data.repository.HeroRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: HeroRepository
) : ViewModel() {
    fun getHeroes(): LiveData<List<Heroes>> {
        val heroes = MutableLiveData<List<Heroes>>()
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getHeroes()
            viewModelScope.launch {
                if (response.isSuccessful) {
                    heroes.value = response.body()
                }
            }
        }
        return heroes
    }
}