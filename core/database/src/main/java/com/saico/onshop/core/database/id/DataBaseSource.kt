package com.saico.onshop.core.database.id

import com.saico.onshop.core.database.datasource.ProductSourceImpl
import com.saico.onshop.core.domain.datasource.local.LocalProductSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataBaseSource {

    @Singleton
    @Binds
    fun bindsProductDatasource(
        impl: ProductSourceImpl
    ): LocalProductSource
}