package com.shahriar.a11_pagination_class_30_to_32.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shahriar.a11_pagination_class_30_to_32.api.QuotesApi
import com.shahriar.a11_pagination_class_30_to_32.model.Result

class QuotesPagingSource(private val api: QuotesApi): PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        return try {

            val position = params.key?: 1

            val response = api.getAllQuotes(position)

            LoadResult.Page(
                response.results,
                if (position==1)null else position-1,
                if (position==response.totalPages)null else position+1
            )
        }catch (e: java.lang.Exception){
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {

        return state.anchorPosition?.let {

            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}