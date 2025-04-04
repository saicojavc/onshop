package com.saico.onshop.core.domain.usecase.product

import com.saico.onshop.core.domain.repository.ProductRepo
import com.saico.onshop.model.product.ProductCartModel
import javax.inject.Inject

class DeleteProductUsesCase @Inject constructor(
    private val repo: ProductRepo
) {
    suspend operator fun invoke(model: ProductCartModel) {
        repo.delete(model)
    }

    suspend operator fun invoke(models: List<ProductCartModel>) {
        repo.delete(models)
    }

    suspend operator fun invoke() {
        repo.deleteAll()
    }

}