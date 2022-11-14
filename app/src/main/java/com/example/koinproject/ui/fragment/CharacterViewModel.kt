package com.example.koinproject.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.koinproject.model.CharacterModel
import com.example.koinproject.repository.CharacterRepository

class CharacterViewModel(
    private val repository: CharacterRepository
): ViewModel() {

    fun fetchKoin(): LiveData<PagingData<CharacterModel>> {
       return repository.fetchKoin().cachedIn(viewModelScope)
    }
}