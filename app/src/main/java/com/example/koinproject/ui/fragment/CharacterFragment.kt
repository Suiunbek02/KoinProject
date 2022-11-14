package com.example.koinproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koinproject.R
import com.example.koinproject.databinding.FragmentKoinBinding
import com.example.koinproject.ui.adapter.CharacterAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment(R.layout.fragment_koin) {

    private val binding by viewBinding(FragmentKoinBinding::bind)
    private val viewModel by viewModel<CharacterViewModel>()
    private val characterAdapter = CharacterAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setupObservers()
    }

    private fun initialize() {
        binding.koinRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setupObservers() {
        viewModel.fetchKoin().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                characterAdapter.submitData(it)
            }
        }
    }
}