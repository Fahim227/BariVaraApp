package com.example.barivara.Data.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.barivara.Data.Entities.Earned
import com.example.barivara.Data.Entities.FlatRentAmount

data class EarnedFromFlat (
    @Embedded val earned: Earned,
    @Relation(
        parentColumn = "flatId",
        entityColumn = "flatId"
    )
    val flatRentAmount: FlatRentAmount
)