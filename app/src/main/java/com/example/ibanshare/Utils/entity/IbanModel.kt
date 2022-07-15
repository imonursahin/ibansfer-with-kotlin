package com.example.ibanshare.Utils

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "ibans")
data class Ibans(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ibanId") @NotNull var ibanId:Int,
    @ColumnInfo(name = "ibanOwner") @NotNull var ibanOwner:String,
    @ColumnInfo(name = "ibanBank") @NotNull var ibanBank:String,
    @ColumnInfo(name = "ibanNumber") @NotNull var ibanNumber:String
) {
}