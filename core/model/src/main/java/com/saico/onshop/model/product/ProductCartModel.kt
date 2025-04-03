package com.saico.onshop.model.product

data class ProductCartModel(
    val id: String,
    val productImg: Int,
    val productName: String,
    val productPrice: String,
    val productQuantity: Int,
)