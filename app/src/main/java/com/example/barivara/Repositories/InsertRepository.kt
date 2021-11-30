package com.example.barivara.Repositories

import com.example.barivara.Data.Dao.DataAccessObject
import com.example.barivara.Data.Entities.*

class InsertRepository(val dataAccessObject: DataAccessObject) {

    suspend fun insertOwner(owner: Owner ):Long{
        return dataAccessObject.insertOwner(owner)
    }

    suspend fun insertRenter(renter: Renter):Long{
        return dataAccessObject.insertRenter(renter)
    }

    suspend fun insertFlat(flatRentAmount: FlatRentAmount):Long{
        return dataAccessObject.insertFlatRentAmount(flatRentAmount)
    }

    suspend fun insertEarnings(earned: Earned):Long{
        return dataAccessObject.insertEarnings(earned)
    }

    suspend fun insertRemains(remain: Remain):Long{
        return dataAccessObject.insertRemains(remain)
    }
}