package com.saico.onshop.core.domain.di

import com.saico.onshop.core.domain.data.ProductRepoImpl
import com.saico.onshop.core.domain.repository.ProductRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsProductRepo(
        impl: ProductRepoImpl
    ): ProductRepo
}
