package com.example.barivara.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.barivara.Repositories.InsertRepository
import com.example.barivara.Repositories.getOrShowRepository
import com.example.barivara.viewModel.LoginViewModel
import java.lang.IllegalArgumentException

class LoginFactory (private val getOrShowRepository: getOrShowRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(getOrShowRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}