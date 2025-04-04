package com.saico.onshop.core.domain.datasource.local

import com.saico.onshop.model.product.ProductCartModel
import kotlinx.coroutines.flow.Flow

interface LocalProductSource {
    suspend fun saveProduct(product : ProductCartModel)

    fun fetchAll(): Flow<List<ProductCartModel>>

    suspend fun update(model: ProductCartModel)
    suspend fun update(models: List<ProductCartModel>)
    suspend fun delete(model: ProductCartModel)
    suspend fun delete(models: List<ProductCartModel>)
    suspend fun deleteById(id: String)
    suspend fun deleteAll()
    suspend fun getProductCount(): Int
}