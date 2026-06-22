package com.rossmannnn.marketplace.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rossmannnn.marketplace.data.model.Deal

@Database(entities = [Deal::class], version = 1, exportSchema = false)
abstract class DealDatabase : RoomDatabase() {
    abstract fun dealDao(): DealDao

    companion object {
        @Volatile
        private var INSTANCE: DealDatabase? = null

        fun getDatabase(context: Context): DealDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DealDatabase::class.java,
                    "deal_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
