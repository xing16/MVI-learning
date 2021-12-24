package com.xing.mvilearning.data.remote

import com.xing.mvilearning.data.service.PlayService

class RemoteDataSourceImpl(private val service: PlayService) : RemoteDataSource {
    override suspend fun register(username: String, password: String) =
        service.register(username, password)
}