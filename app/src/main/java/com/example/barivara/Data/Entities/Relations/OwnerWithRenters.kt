package com.example.barivara.Data.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.barivara.Data.Entities.Owner
import com.example.barivara.Data.Entities.Renter

data class OwnerWithRenters (
        @Embedded val owner: Owner,
        @Relation(
                parentColumn = "ownerId",
                entityColumn = "ownerId"

        )
        val renterList:List<Renter>
)