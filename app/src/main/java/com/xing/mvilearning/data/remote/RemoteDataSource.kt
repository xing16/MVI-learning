package com.xing.mvilearning.data.remote

import com.xing.mvilearning.model.User

interface RemoteDataSource {
    suspend fun register(username: String, password: String): User
}