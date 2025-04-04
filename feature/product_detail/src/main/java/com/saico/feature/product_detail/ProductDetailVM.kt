package com.saico.feature.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saico.feature.product_detail.model.ProductDetailUiState
import com.saico.onshop.core.domain.usecase.product.ProductUseCase
import com.saico.onshop.model.product.ProductCartModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailVM @Inject constructor(
    private val productUseCase: ProductUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductDetailUiState())
    val uiState = _uiState.asStateFlow()

    fun fetchProductCount(){
        viewModelScope.launch {
            val count = productUseCase.getProductCountUsesCase()
            _uiState.value = uiState.value.copy(
                productCount = count
            )
        }
    }

    fun addProductToCart(
        id: String,
        productImg: Int,
        productName: String,
        productPrice: String,
        productQuantity: Int
    ){
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                isLoading = true
            )
            try {
                val product = ProductCartModel(
                    id = id,
                    productImg = productImg,
                    productName = productName,
                    productPrice = productPrice,
                    productQuantity = productQuantity
                )
                productUseCase.saveProductUseCase(product)
            }catch (e: Exception){
                _uiState.value = uiState.value.copy(
                    errorMessage = e.message
                )
            } finally {
                delay(1000)
                _uiState.value = uiState.value.copy(
                    isLoading =  false
                )
            }
        }
    }

}