package com.xing.mvilearning.data.repository

import com.xing.mvilearning.http.ApiResult
import com.xing.mvilearning.model.HomeArticle
import com.xing.mvilearning.model.User

interface Repository {
    suspend fun register(username: String, password: String): User

    suspend fun getHomeArticle(page: Int): ApiResult<HomeArticle>
}