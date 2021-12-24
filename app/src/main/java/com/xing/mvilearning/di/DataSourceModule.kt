package com.xing.mvilearning.di

import com.xing.mvilearning.data.remote.RemoteDataSource
import com.xing.mvilearning.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(service = get())
    }
}