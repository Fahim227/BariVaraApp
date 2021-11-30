package com.example.barivara.Data.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.barivara.Data.Entities.*
import com.example.barivara.Data.Entities.Relations.EarnedFromFlat
import com.example.barivara.Data.Entities.Relations.FlatWithRenter
import com.example.barivara.Data.Entities.Relations.RenterWithFlats

@Dao
interface DataAccessObject {

    @Insert
    suspend fun insertOwner(owner:Owner):Long

    @Insert
    suspend fun insertRenter(renter: Renter):Long

    @Insert
    suspend fun insertEarnings(earned: Earned):Long

    @Insert
    suspend fun insertRemains(remain: Remain):Long

    @Insert
    suspend fun insertFlatRentAmount(flatRentAmount: FlatRentAmount):Long

    //getFlatListWithRenter

    @Transaction
    @Query("SELECT * FROM FLATRENTAMOUNT WHERE flatOwnerId= :ownerId")
    fun getFlatListWithRenter(ownerId:Int): LiveData<List<FlatWithRenter>>

    //get Renters List with flat number
    @Transaction
    @Query("SELECT * FROM Renter WHERE ownerId= :ownerId")
    fun getRenterListWithFlatNumber(ownerId:Int): LiveData<List<RenterWithFlats>>

    // get Earned List with flatNumber
    @Transaction
    @Query("SELECT * FROM Earned WHERE ownerId= :ownerId")
    fun getEarnedFromFlat(ownerId:Int): LiveData<List<EarnedFromFlat>>

    // get Remain amounts with renter and flat details

    @Query("SELECT * FROM Owner WHERE email= :email")
    suspend fun getOwnerData(email:String): List<Owner>


}