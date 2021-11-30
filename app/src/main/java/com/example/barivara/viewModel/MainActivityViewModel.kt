package com.example.barivara.viewModel

import android.util.Log
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barivara.Data.Entities.Owner
import com.example.barivara.Repositories.InsertRepository
import com.example.barivara.View.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel(private val insertRepository: InsertRepository) : ViewModel(){


    val name = MutableLiveData<String?>()

    val age = MutableLiveData<String?>()

    val email = MutableLiveData<String?>()

    val phone = MutableLiveData<String?>()

    val password = MutableLiveData<String?>()

    fun register() = viewModelScope.launch{
        //Log.i("check",name.value!!+age.value!!+email.value+phone.value+password.value)
        val owner = Owner(0,name.value.toString(),age.value.toString().toInt(),phone.value.toString(),email.value.toString(),password.value.toString())
        Log.i("check",owner.toString())
        insertRepository.dataAccessObject.insertOwner(owner)
    }
}