package com.example.barivara.Data.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Earned (
    @PrimaryKey(autoGenerate = true)
    val earnedId:Int,
    val date:Int,
    val renterId:Int,
    val ownerID:Int,
    val amount:Int,
    val flatId:Int
)