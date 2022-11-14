package com.example.koinproject.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.koinproject.data.network.CharacterApi.CharacterApi
import com.example.koinproject.model.CharacterModel
import com.example.koinproject.repository.pagingsources.CharacterPagingSources

class CharacterRepository(
    private val koinApi: CharacterApi) {

    fun fetchKoin(): LiveData<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSources(koinApi)
            }, initialKey = 1
        ).liveData
    }
}