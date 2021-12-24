package com.xing.mvilearning.di

import com.xing.mvilearning.ui.login.LoginRegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 * @ClassName: ViewModelModule
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/12/24 16:25
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/12/24 16:25
 * @UpdateRemark: 无
 */
val viewModelModule = module {
    viewModel {
        LoginRegisterViewModel(repository = get())
    }
}