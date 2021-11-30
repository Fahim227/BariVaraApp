package com.example.barivara.Data.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FlatRentAmount (
    @PrimaryKey(autoGenerate = true)
    val flatId:Int,
    val flatNumber:Int,
    val amount:Int,
    val flatOwnerId:Int,
    val flatRenterId:Int,
    val isRented:Int

)