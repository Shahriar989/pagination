package com.shahriar.a11_pagination_class_30_to_32.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shahriar.a11_pagination_class_30_to_32.databinding.ItemProgressBinding

class LoadingAdapter : LoadStateAdapter<LoadingAdapter.LoadViewHolder>() {

    inner class LoadViewHolder(val binding: ItemProgressBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindState(loadState: LoadState) {

            binding.progressCircular.isVisible = loadState is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: LoadViewHolder, loadState: LoadState) {
        holder.bindState(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadViewHolder {
        return LoadViewHolder(
            ItemProgressBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}