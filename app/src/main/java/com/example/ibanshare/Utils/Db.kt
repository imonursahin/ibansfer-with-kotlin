package com.example.ibanshare.Utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ibans::class], version = 1)
abstract class Db : RoomDatabase() {
    abstract fun IbanDao(): IbanDao

    companion object {
        var INSTANCE: Db? = null

        fun getInstance(context: Context): Db? {
            if (INSTANCE == null) {
                synchronized(Db::class) {
                    INSTANCE = Room.databaseBuilder(context, Db::class.java, "ibans.sqlite").build()

                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Db::class.java,
                        "ibans.sqlite"
                    ).createFromAsset("ibans.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}