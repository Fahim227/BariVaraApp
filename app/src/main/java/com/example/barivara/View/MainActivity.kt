package com.example.barivara.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.barivara.Data.Dao.DataAccessObject
import com.example.barivara.Data.DataBase.BariVaraDB
import com.example.barivara.Data.DataBase.BariVaraDB.Companion.getInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.example.barivara.Data.Entities.Owner
import com.example.barivara.R
import com.example.barivara.Repositories.InsertRepository
import com.example.barivara.databinding.ActivityMainBinding
import com.example.barivara.factories.MainActivityViewModelFactory
import com.example.barivara.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var bariVaraDB:BariVaraDB
    lateinit var regButton: Button
    lateinit var mainActivityViewModel:MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dataAccessObject = BariVaraDB.getInstance(application).getDao()
        val repository = InsertRepository(dataAccessObject)
        val factory = MainActivityViewModelFactory(repository)
        mainActivityViewModel = ViewModelProvider(this,factory).get(MainActivityViewModel::class.java)
        binding.registration = mainActivityViewModel
        binding.lifecycleOwner = this

        regButton = findViewById(R.id.regButtonID)
        regButton.setOnClickListener(this)

    }


    override fun onClick(v: View?) {

        mainActivityViewModel.register()

        val intent = Intent(this,Login::class.java)
        startActivity(intent)

    }

}