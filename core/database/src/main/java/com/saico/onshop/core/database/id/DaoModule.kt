package com.saico.onshop.core.database.id

import com.saico.onshop.core.database.KRoomDatabase
import com.saico.onshop.core.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    @Singleton
    fun providesProductDao(
        database: KRoomDatabase
    ): ProductDao {
        return database.productDao()
    }
}