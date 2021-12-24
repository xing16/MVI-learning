package com.xing.mvilearning.data.repository

import com.xing.mvilearning.model.User

interface Repository {
    suspend fun register(username: String, password: String): User
}