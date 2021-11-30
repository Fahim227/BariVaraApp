package com.example.barivara.Data.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.barivara.Data.Entities.FlatRentAmount
import com.example.barivara.Data.Entities.Owner
import com.example.barivara.Data.Entities.Renter

data class RenterWithFlats(
    @Embedded val renter:Renter,
    @Relation(
            parentColumn = "renterId",
            entityColumn = "flatRenterId"
    )
    val flatList:List<FlatRentAmount>
)