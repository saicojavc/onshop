package com.saico.feature.product_detail.model

data class ProductDetailUiState (
    val id: String = "",
    val productImg: String = "",
    val productName: String = "",
    val productPrice: String = "",
    val productType: String = "",
    val productQuantity: Int = 0,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val productCount: Int = 0,
    val charging: Boolean = false,
)