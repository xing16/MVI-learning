package com.xing.mvilearning.data.repository

import com.xing.mvilearning.data.remote.RemoteDataSource

class RepositoryImpl(private val dataSource: RemoteDataSource) : Repository {
    override suspend fun register(username: String, password: String) = dataSource.register(username, password)
}