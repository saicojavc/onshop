package com.saico.onshop.core.database.datasource

import com.saico.onshop.core.database.dao.ProductDao
import com.saico.onshop.core.database.mapper.toEntity
import com.saico.onshop.core.database.mapper.toModel
import com.saico.onshop.core.domain.datasource.local.LocalProductSource
import com.saico.onshop.model.product.ProductCartModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


class ProductSourceImpl @Inject constructor(
    private val dao: ProductDao
) : LocalProductSource {
    override suspend fun saveProduct(product: ProductCartModel) {
        dao.insert(product.toEntity())
    }

    override fun fetchAll(): Flow<List<ProductCartModel>> =
        dao.fetchAll().map { data -> data.map { it.toModel() } }

    override suspend fun update(model: ProductCartModel) {
        dao.update(model.toEntity())
    }

    override suspend fun update(models: List<ProductCartModel>) {
        dao.update(models.map { it.toEntity() })
    }

    override suspend fun delete(model: ProductCartModel) {
        dao.delete(model.toEntity())
    }

    override suspend fun delete(models: List<ProductCartModel>) {
        dao.delete(models.map { it.toEntity() })
    }

    override suspend fun deleteById(id: String) {
        dao.deleteById(id)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun getProductCount(): Int {
        return dao.getProductCount()
    }
}
