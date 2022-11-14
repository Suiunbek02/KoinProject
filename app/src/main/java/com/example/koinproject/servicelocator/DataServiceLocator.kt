package com.example.koinproject.servicelocator

import com.example.koinproject.repository.CharacterRepository
import com.example.koinproject.ui.fragment.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {

    factory {
        CharacterRepository(get())
    }

    viewModel{
        CharacterViewModel(get())
    }
}