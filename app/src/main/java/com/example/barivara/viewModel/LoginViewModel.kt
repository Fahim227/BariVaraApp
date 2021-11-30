package com.example.barivara.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barivara.Data.Entities.Owner
import com.example.barivara.Repositories.getOrShowRepository
import com.example.barivara.View.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginViewModel(private val getOrShowRepository: getOrShowRepository) : ViewModel() {

     val emailOrPhone = MutableLiveData<String?>()

     val password = MutableLiveData<String?>()

     val userId = MutableLiveData<Int>()

     fun userLogin(){

          Log.i("emailOwner",emailOrPhone.value.toString())
          viewModelScope.launch(Dispatchers.IO){
               val ownerList = getOrShowRepository.checkForLogin(emailOrPhone.value.toString())
               for (owner in ownerList){
                    if (password.value.toString().equals(owner.password)){
                         userId.value = owner.ownerId
                    }
               }
          }

          // Log.i("OwnerData",owner.toString())

          /*.observe(this, androidx.lifecycle.Observer {
            activityMainBinding.reader = it.toString()
        })*/

     }

     fun register(){
          // go to register activity



     }
}