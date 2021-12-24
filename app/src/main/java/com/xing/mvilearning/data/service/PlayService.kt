package com.xing.mvilearning.data.service

import com.xing.mvilearning.http.ApiResult
import com.xing.mvilearning.model.HomeArticle
import com.xing.mvilearning.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayService {
    suspend fun register(username: String, password: String): User

    @GET("article/list/{page}/json")
    suspend fun getHomeArticle(@Path("page") page: Int): ApiResult<HomeArticle>
}