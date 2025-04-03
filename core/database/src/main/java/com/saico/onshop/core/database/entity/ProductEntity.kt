package com.saico.onshop.core.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saico.onshop.core.database.util.PRODUCT_ID
import com.saico.onshop.core.database.util.PRODUCT_IMG
import com.saico.onshop.core.database.util.PRODUCT_NAME
import com.saico.onshop.core.database.util.PRODUCT_PRICE
import com.saico.onshop.core.database.util.PRODUCT_QUANTITY
import com.saico.onshop.core.database.util.PRODUCT_TABLE
import kotlinx.parcelize.Parcelize

@Entity(tableName = PRODUCT_TABLE)
@Parcelize
data class ProductEntity(
    @PrimaryKey @ColumnInfo(name = PRODUCT_ID) val id: String,
    @ColumnInfo(name = PRODUCT_IMG) val productImg: Int,
    @ColumnInfo(name = PRODUCT_NAME) val productName: String,
    @ColumnInfo(name = PRODUCT_PRICE) val productPrice: String,
    @ColumnInfo(name = PRODUCT_QUANTITY) val productQuantity: Int
) : Parcelable