package com.xing.mvilearning.ui.login

import com.xing.mvilearning.base.IState
import com.xing.mvilearning.model.User

sealed class LoginRegisterState : IState {
    object Idle : LoginRegisterState()
    object Loading : LoginRegisterState()
    data class RegisterResult(val user: User) : LoginRegisterState()
    data class Error(val exception: Exception) : LoginRegisterState()
}