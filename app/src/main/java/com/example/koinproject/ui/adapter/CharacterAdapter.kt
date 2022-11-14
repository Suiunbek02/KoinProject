package com.example.koinproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.koinproject.databinding.ItemKoinBinding
import com.example.koinproject.model.CharacterModel

class CharacterAdapter : PagingDataAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffUtil) {
    class ViewHolder(private val binding: ItemKoinBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: CharacterModel?) {
            binding.itemKoinText.text = item?.id.toString()
            binding.itemKoinText.text = item?.name
            binding.itemKoinImage.load(item?.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemKoinBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}