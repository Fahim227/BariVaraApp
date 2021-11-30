package com.example.barivara.Data.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.barivara.Data.Entities.FlatRentAmount
import com.example.barivara.Data.Entities.Owner

data class OwnerWithFlats (
        @Embedded val owner: Owner,
        @Relation(
                parentColumn = "ownerId",
                entityColumn = "flatOwnerId"
        )
        val flatList:List<FlatRentAmount>
)