package com.saico.onshop.core.domain.usecase.product

import com.saico.onshop.core.domain.repository.ProductRepo
import javax.inject.Inject

class DeleteProductByIdUsesCase @Inject constructor(
    private val repo: ProductRepo
){
    suspend operator fun invoke(id: String) =
        repo.deleteById(id)
}
