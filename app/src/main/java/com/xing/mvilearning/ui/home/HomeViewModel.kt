package com.xing.mvilearning.ui.home

import androidx.lifecycle.ViewModel
import com.xing.mvilearning.base.IModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel(), IModel<HomeState, HomeIntent> {
    override val intents: Channel<HomeIntent> = Channel(Channel.UNLIMITED)
    override val state: StateFlow<HomeState>
        get() = _state
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Idle)
}