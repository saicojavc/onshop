package com.saico.onshop.core.domain.repository

import com.saico.onshop.model.ResultValue
import com.saico.onshop.model.product.ProductCartModel
import kotlinx.coroutines.flow.Flow

interface ProductRepo {
    suspend fun saveProduct(product: ProductCartModel)

    fun fetchAll(): Flow<List<ProductCartModel>>

    suspend fun update(model: ProductCartModel)
    suspend fun update(models: List<ProductCartModel>)
    suspend fun delete(model: ProductCartModel)
    suspend fun delete(models: List<ProductCartModel>)
    suspend fun deleteById(id: String)
    suspend fun deleteAll()
    suspend fun getProductCount(): Int

}