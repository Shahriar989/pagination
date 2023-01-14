package com.shahriar.a11_pagination_class_30_to_32.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.shahriar.a11_pagination_class_30_to_32.repo.QuotesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val repo: QuotesRepo): ViewModel() {

    val quoteList = repo.getAllQuotes().cachedIn(viewModelScope)
}