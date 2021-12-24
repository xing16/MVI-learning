package com.xing.mvilearning.di

import com.xing.mvilearning.ui.home.HomeViewModel
import com.xing.mvilearning.ui.login.LoginRegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginRegisterViewModel(repository = get())
    }

    viewModel {
        HomeViewModel(repository = get())
    }
}