package com.xing.mvilearning.di

import com.xing.mvilearning.data.repository.Repository
import com.xing.mvilearning.data.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> {
        RepositoryImpl(dataSource = get())
    }
}