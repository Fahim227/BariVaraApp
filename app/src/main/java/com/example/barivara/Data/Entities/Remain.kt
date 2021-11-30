package com.example.barivara.Data.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Remain (
       @PrimaryKey(autoGenerate = true)
       val remainId:Int,
       val renterId:Int,
       val ownerId:Int,
       val remainAmount:Int,
       val note:String,
       val flatId:Int
)