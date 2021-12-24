package com.xing.mvilearning.data.remote

import com.xing.mvilearning.http.ApiResult
import com.xing.mvilearning.model.HomeArticle
import com.xing.mvilearning.model.User

interface RemoteDataSource {
    suspend fun register(username: String, password: String): User

    suspend fun getHomeArticle(page: Int): ApiResult<HomeArticle>
}