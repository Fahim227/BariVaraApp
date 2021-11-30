package com.example.barivara.Data.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.barivara.Data.Entities.Earned
import com.example.barivara.Data.Entities.FlatRentAmount
import com.example.barivara.Data.Entities.Owner

class OwnerWithEarns (
        @Embedded val owner: Owner,
        @Relation(
                parentColumn = "ownerId",
                entityColumn = "flatOwnerId"
        )
        val earnsList:List<Earned>
)