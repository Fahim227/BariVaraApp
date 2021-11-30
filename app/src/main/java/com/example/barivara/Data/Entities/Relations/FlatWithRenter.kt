package com.example.barivara.Data.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.barivara.Data.Entities.FlatRentAmount
import com.example.barivara.Data.Entities.Renter

data class FlatWithRenter(
    @Embedded
    val flatRentAmount: FlatRentAmount,
    @Relation(
        parentColumn = "flatId",
        entityColumn = "rentedFlatId"
    )
    val renter: Renter
)