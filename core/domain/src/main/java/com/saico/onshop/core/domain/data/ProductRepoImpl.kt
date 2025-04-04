package com.saico.onshop.core.domain.data

import com.saico.onshop.core.domain.datasource.local.LocalProductSource
import com.saico.onshop.core.domain.repository.ProductRepo
import com.saico.onshop.model.product.ProductCartModel
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val local : LocalProductSource,
) : ProductRepo {
    override suspend fun saveProduct(product: ProductCartModel) {
        local.saveProduct(product)
    }

    override fun fetchAll() =
        local.fetchAll()


    override suspend fun update(model: ProductCartModel) {
        local.update(model)
    }

    override suspend fun update(models: List<ProductCartModel>) {
        local.update(models)
    }

    override suspend fun delete(model: ProductCartModel) {
        local.delete(model)
    }

    override suspend fun delete(models: List<ProductCartModel>) {
        local.delete(models)
    }

    override suspend fun deleteById(id: String) {
        local.deleteById(id)
    }

    override suspend fun deleteAll() {
        local.deleteAll()
    }

    override suspend fun getProductCount(): Int {
        return local.getProductCount()
    }


}