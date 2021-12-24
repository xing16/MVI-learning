package com.xing.mvilearning.http

data class ApiResult<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)