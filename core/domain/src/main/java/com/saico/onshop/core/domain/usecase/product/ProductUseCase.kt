package com.saico.onshop.core.domain.usecase.product

import javax.inject.Inject

data class ProductUseCase @Inject constructor(
    val saveProductUseCase: SaveProductUseCase,
    val fetchProductUseCase: FetchProductUseCase,
    val updateProductUseCase: UpdateProductUseCase,
    val deleteProductUseCase: DeleteProductUsesCase,
    val deleteProductByIdUseCase: DeleteProductByIdUsesCase,
    val getProductCountUsesCase: GetProductCountUsesCase,

//    val getProductDetailUseCase: GetProductDetailUseCase
)