package com.saico.feature.home.model.product

import com.saico.onshop.ui.R

data class Product(
    val manList : List<Int> = listOf(
        R.drawable.men1_1,
        R.drawable.men2,
        R.drawable.men3,
        R.drawable.men4,
        R.drawable.men5,
        R.drawable.men6,
        R.drawable.men7,
        R.drawable.men8
    ),
    val brandList : List<Int>  = listOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6,
    ),
    val brandText : List<String>  = listOf(
        "Adidas", "Nike", "Puma", "ZARA", "Gucci", "Prada"
    )
)


