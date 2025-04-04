package com.saico.onshop.core.domain.usecase.product

import com.saico.onshop.core.domain.repository.ProductRepo
import com.saico.onshop.model.product.ProductCartModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FetchProductUseCase @Inject constructor(
    private val repo: ProductRepo
){
    operator fun invoke(): Flow<List<ProductCartModel>> {
        return repo.fetchAll()
    }
}
