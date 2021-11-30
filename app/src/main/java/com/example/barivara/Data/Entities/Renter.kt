package com.example.barivara.Data.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Renter (
    @PrimaryKey(autoGenerate = true)
    val renterId:Int,
    val name:String,
    val age:Int,
    val phonse:String,
    val nId:String,
    val email:String,
    val rentedFlatId:Int,
    val ownerId:Int,
    val startingMonthYear:String

)
