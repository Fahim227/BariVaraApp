package com.example.barivara.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.barivara.Repositories.InsertRepository
import com.example.barivara.viewModel.MainActivityViewModel
import java.lang.IllegalArgumentException

class MainActivityViewModelFactory(private val insertRepository: InsertRepository):
    ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
                return MainActivityViewModel(insertRepository) as T
            }
            throw IllegalArgumentException("Unknown View Model class")
        }
}