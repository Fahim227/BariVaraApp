package com.example.barivara.Data.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner (
    @PrimaryKey(autoGenerate = true)
    val ownerId:Int,
    val name:String,
    val age:Int,
    val phone:String,
    val email:String,
    val password:String
)