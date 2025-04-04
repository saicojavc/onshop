package com.saico.onshop.core.domain.usecase.product

import com.saico.onshop.core.domain.repository.ProductRepo
import com.saico.onshop.model.product.ProductCartModel
import javax.inject.Inject

class SaveProductUseCase @Inject constructor(
    private val repo: ProductRepo
){
    suspend operator fun invoke(product: ProductCartModel){
        repo.saveProduct(product)
    }
}