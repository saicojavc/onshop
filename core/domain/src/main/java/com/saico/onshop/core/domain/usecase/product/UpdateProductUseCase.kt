package com.saico.onshop.core.domain.usecase.product

import com.saico.onshop.core.domain.repository.ProductRepo
import com.saico.onshop.model.product.ProductCartModel
import javax.inject.Inject

class UpdateProductUseCase @Inject constructor(
    private val repo: ProductRepo
){
    suspend operator fun invoke(product: ProductCartModel){
        repo.update(product)
    }

    suspend operator fun invoke(products: List<ProductCartModel>){
        repo.update(products)
    }
}