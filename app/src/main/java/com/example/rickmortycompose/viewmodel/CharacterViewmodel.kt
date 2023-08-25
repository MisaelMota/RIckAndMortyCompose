package com.example.rickmortycompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmortycompose.models.Character
import com.example.rickmortycompose.repositories.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewmodel:ViewModel(){
    private val repository= CharacterRepository()

    private val _characters=MutableLiveData<List<Character>>()
    val characters:LiveData<List<Character>> = _characters

    fun getCharacters(){
        viewModelScope.launch {
            _characters.value = repository.getCharacters()
        }
    }
}