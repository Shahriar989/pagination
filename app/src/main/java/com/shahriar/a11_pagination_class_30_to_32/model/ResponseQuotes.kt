package com.shahriar.a11_pagination_class_30_to_32.model

data class ResponseQuotes(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)