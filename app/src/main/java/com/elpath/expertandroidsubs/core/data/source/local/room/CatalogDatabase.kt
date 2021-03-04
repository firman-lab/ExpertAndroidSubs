package com.elpath.expertandroidsubs.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elpath.expertandroidsubs.core.data.source.local.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class CatalogDatabase : RoomDatabase() {

    abstract fun catalogDao() : CatalogDao

    companion object{
        @Volatile
        private var INSTANCE : CatalogDatabase? = null

        fun getInstance(context: Context) : CatalogDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatalogDatabase::class.java,
                    "CatalogDB"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE =  instance
                instance
            }
    }
}