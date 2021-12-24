package com.xing.mvilearning.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xing.mvilearning.base.IModel
import com.xing.mvilearning.data.repository.Repository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel(), IModel<HomeState, HomeIntent> {
    override val intents: Channel<HomeIntent> = Channel(Channel.UNLIMITED)
    override val state: StateFlow<HomeState>
        get() = _state
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Idle)

    init {
        handleIntent(0)
    }

    private fun handleIntent(page: Int) {
        viewModelScope.launch {
            intents.consumeAsFlow().collect {
                when (it) {
                    is HomeIntent.Fetch -> {
                        fetchArticleData(page)
                    }
                }
            }
        }
    }

    private fun fetchArticleData(page: Int) {
        viewModelScope.launch {
            _state.value = HomeState.Loading
            _state.value = try {
                HomeState.HomeResult(repository.getHomeArticle(page))
            } catch (e: Exception) {
                HomeState.Error(e)
            }
        }
    }
}