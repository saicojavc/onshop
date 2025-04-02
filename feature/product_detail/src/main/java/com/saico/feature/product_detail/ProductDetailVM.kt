package com.saico.feature.product_detail

import androidx.lifecycle.ViewModel
import com.saico.feature.product_detail.model.ProductDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailVM @Inject constructor(

) : ViewModel(){
    private val _uiState = MutableStateFlow(ProductDetailUiState())
    val uiState = _uiState.asStateFlow()
}