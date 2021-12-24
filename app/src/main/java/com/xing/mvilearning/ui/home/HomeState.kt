package com.xing.mvilearning.ui.home

import com.xing.mvilearning.base.IState
import com.xing.mvilearning.http.ApiResult
import com.xing.mvilearning.model.HomeArticle

sealed class HomeState : IState {
    object Idle : HomeState()
    object Loading : HomeState()
    data class Error(val exception: Exception) : HomeState()
    data class HomeResult(val article: ApiResult<HomeArticle>) : HomeState()
}