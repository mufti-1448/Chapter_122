package com.mufti.chapter11.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Friend::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun friendDao(): FriendDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val tempImplements = INSTANCE
            if (tempImplements != null) {
                return tempImplements
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "my_database"
            )
                .fallbackToDestructiveMigration()
                .build()

            INSTANCE = instance
            return instance
        }
    }
}