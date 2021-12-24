package com.xing.mvilearning.ui.login

import com.xing.mvilearning.base.IIntent

sealed class LoginRegisterIntent : IIntent {
    object Register : LoginRegisterIntent()
}