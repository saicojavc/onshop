package com.saico.onshop.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.saico.onshop.core.database.entity.ProductEntity
import com.saico.onshop.core.database.util.PRODUCT_ID
import com.saico.onshop.core.database.util.PRODUCT_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Upsert
    suspend fun insert(mode: ProductEntity)

    @Upsert
    suspend fun insert(models: List<ProductEntity>)

    @Update
    suspend fun update(mode: ProductEntity)

    @Update
    suspend fun update(models: List<ProductEntity>)

    @Delete
    suspend fun delete(mode: ProductEntity)

    @Delete
    suspend fun delete(models: List<ProductEntity>)

    @Query("DELETE FROM $PRODUCT_TABLE WHERE $PRODUCT_ID IN (:id)")
    suspend fun deleteById(id: String)

    @Query("DELETE FROM $PRODUCT_TABLE")
    suspend fun deleteAll()

    @Query("SELECT * FROM $PRODUCT_TABLE")
    fun fetchAll(): Flow<List<ProductEntity>>

    @Query("SELECT COUNT(*) FROM $PRODUCT_TABLE")
    suspend fun getProductCount(): Int
}