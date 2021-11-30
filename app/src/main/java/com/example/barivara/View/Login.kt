package com.example.barivara.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.barivara.Data.DataBase.BariVaraDB
import com.example.barivara.R
import com.example.barivara.Repositories.InsertRepository
import com.example.barivara.Repositories.getOrShowRepository
import com.example.barivara.databinding.ActivityLoginBinding
import com.example.barivara.factories.LoginFactory
import com.example.barivara.factories.MainActivityViewModelFactory
import com.example.barivara.viewModel.LoginViewModel
import com.example.barivara.viewModel.MainActivityViewModel
import kotlin.math.log

class Login : AppCompatActivity(), View.OnClickListener{
    lateinit var resTextView: TextView
    lateinit var login : Button
    lateinit var loginViewModel: LoginViewModel
    lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val dataAccessObject = BariVaraDB.getInstance(application).getDao()
        val repository = getOrShowRepository(dataAccessObject)
        val factory = LoginFactory(repository)
        loginViewModel = ViewModelProvider(this,factory).get(LoginViewModel::class.java)
        loginBinding.login = loginViewModel
        loginBinding.lifecycleOwner = this

        resTextView = findViewById(R.id.registerTextId)
        login = findViewById(R.id.loginButtonId)
        resTextView.setOnClickListener(this)
        login.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.registerTextId){
                Log.d("Testing: ","Came")
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            if (v.id == R.id.loginButtonId){
                loginViewModel.userLogin()
                Log.i("UserID: ",loginViewModel.userId.value.toString())
            }
        }

    }
}