package com.saico.onshop.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saico.onshop.core.database.dao.ProductDao
import com.saico.onshop.core.database.entity.ProductEntity
import com.saico.onshop.core.database.util.DB_VERSION

@Database(
    entities = [
        ProductEntity::class
    ],
    version = DB_VERSION, exportSchema = false
)
abstract class KRoomDatabase : RoomDatabase(){
    abstract fun productDao() : ProductDao
}