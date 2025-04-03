package com.saico.onshop.core.database.mapper

import com.saico.onshop.core.database.entity.ProductEntity
import com.saico.onshop.model.product.ProductCartModel

fun ProductCartModel.toEntity() = ProductEntity(
    id = this.id,
    productImg = this.productImg,
    productName = this.productName,
    productQuantity = this.productQuantity,
    productPrice = this.productPrice,
)

fun ProductEntity.toModel() = ProductCartModel(
    id = this.id,
    productPrice = this.productPrice,
    productName = this.productName,
    productImg = this.productImg,
    productQuantity = this.productQuantity,
)