package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var userStateMutableLiveData = MutableLiveData<UserState>()
    var userState: LiveData<UserState> = userStateMutableLiveData

    init {
        userStateMutableLiveData.value = UserState.LOGGED_OUT
    }

    fun login(email: String, password: String) {
        userStateMutableLiveData.value = UserState.LOGGED_IN
    }

    fun logout() {
        userStateMutableLiveData.value = UserState.LOGGED_OUT
    }
}

enum class UserState {
    LOGGED_IN,
    LOGGED_OUT
}