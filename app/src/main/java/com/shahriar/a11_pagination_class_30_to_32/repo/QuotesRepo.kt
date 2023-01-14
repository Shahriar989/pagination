package com.shahriar.a11_pagination_class_30_to_32.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.shahriar.a11_pagination_class_30_to_32.api.QuotesApi
import com.shahriar.a11_pagination_class_30_to_32.pagination.QuotesPagingSource
import javax.inject.Inject

class QuotesRepo @Inject constructor(private val quotesApi: QuotesApi){

    fun getAllQuotes() = Pager(

        config = PagingConfig(20, maxSize = 100),
        pagingSourceFactory = {QuotesPagingSource(quotesApi)}
    ).liveData
}