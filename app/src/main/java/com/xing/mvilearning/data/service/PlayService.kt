package com.xing.mvilearning.data.service

import com.xing.mvilearning.http.Result
import com.xing.mvilearning.model.HomeArticle
import com.xing.mvilearning.model.User
import retrofit2.http.GET

interface PlayService {
    suspend fun register(username: String, password: String): User

    @GET("article/list/{page}/json")
    suspend fun getHomeArticle(page: Int): Result<HomeArticle>
}