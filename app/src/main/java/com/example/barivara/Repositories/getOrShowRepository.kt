package com.example.barivara.Repositories

import androidx.lifecycle.LiveData
import com.example.barivara.Data.Dao.DataAccessObject
import com.example.barivara.Data.Entities.Owner
import com.example.barivara.Data.Entities.Relations.EarnedFromFlat
import com.example.barivara.Data.Entities.Relations.FlatWithRenter
import com.example.barivara.Data.Entities.Relations.RenterWithFlats

class getOrShowRepository(val dataAccessObject: DataAccessObject) {

    fun getFlatListWithRenter(ownerId:Int): LiveData<List<FlatWithRenter>>{
        return dataAccessObject.getFlatListWithRenter(ownerId)
    }

    fun getRenterListWithFlatNumber(ownerId:Int): LiveData<List<RenterWithFlats>>{
        return  dataAccessObject.getRenterListWithFlatNumber(ownerId)
    }

    fun getEarnedFromFlat(ownerId:Int): LiveData<List<EarnedFromFlat>>{
        return dataAccessObject.getEarnedFromFlat(ownerId)
    }

    suspend fun checkForLogin(email:String): List<Owner>{
        return dataAccessObject.getOwnerData(email)
    }


}