package com.xing.mvilearning.ui.home

import com.xing.mvilearning.base.IIntent

sealed class HomeIntent : IIntent {
    data class Fetch(val page: Int) : HomeIntent()
}