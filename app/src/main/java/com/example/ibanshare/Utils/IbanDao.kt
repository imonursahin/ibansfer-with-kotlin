package com.example.ibanshare.Utils

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IbanDao {

    @Query("SELECT * FROM ibans")
    suspend fun getAllIbans(): List<Ibans>

    @Insert
    suspend fun addIban(ibans: Ibans)

    @Delete
    suspend fun deleteIban(ibans: Ibans)

}