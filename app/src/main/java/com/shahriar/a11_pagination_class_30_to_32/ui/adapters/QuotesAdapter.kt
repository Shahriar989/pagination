package com.shahriar.a11_pagination_class_30_to_32.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shahriar.a11_pagination_class_30_to_32.databinding.ItemQuotesBinding
import com.shahriar.a11_pagination_class_30_to_32.model.Result

class QuotesAdapter: PagingDataAdapter<Result, QuotesAdapter.QuotesViewHolder>(Comparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        return QuotesViewHolder(
            ItemQuotesBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {

//        var quotes: Result= getItem(position)!!
//        holder.itemQuotesBinding.quoteTV.text = quotes.content
        getItem(position).let {
            holder.itemQuotesBinding.quoteTV.text = it?.content
        }
    }

    class QuotesViewHolder (val itemQuotesBinding: ItemQuotesBinding):
        RecyclerView.ViewHolder(itemQuotesBinding.root)

    companion object{

        private val Comparator = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return  oldItem._id==newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem==newItem
            }
        }
    }
}