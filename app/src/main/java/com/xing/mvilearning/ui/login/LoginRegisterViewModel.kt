package com.xing.mvilearning.ui.login

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

class LoginRegisterViewModel(private val repository: Repository) : ViewModel(), IModel<LoginRegisterState, LoginRegisterIntent> {
    override val intents: Channel<LoginRegisterIntent> = Channel(Channel.UNLIMITED)
    override val state: StateFlow<LoginRegisterState>
        get() = _state
    private val _state: MutableStateFlow<LoginRegisterState> = MutableStateFlow(LoginRegisterState.Idle)

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect {
                when (it) {
                    is LoginRegisterIntent.Register -> register()
                }
            }
        }
    }

    fun register() {
        viewModelScope.launch {
            _state.value = LoginRegisterState.Loading
            _state.value = try {
                LoginRegisterState.RegisterResult(repository.register())
            } catch (e: Exception) {
                LoginRegisterState.Error(e)
            }
        }
    }
}