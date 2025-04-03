package com.saico.onshop.core.database.id

import android.content.Context
import androidx.room.Room
import com.google.android.datatransport.runtime.dagger.Module
import com.saico.onshop.core.database.KRoomDatabase
import com.saico.onshop.core.database.dao.ProductDao
import com.saico.onshop.core.database.util.DB_NAME
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): KRoomDatabase = Room
        .databaseBuilder(context, KRoomDatabase::class.java, DB_NAME)
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
    @Singleton
    @Provides
    fun provideProductDao(
        database: KRoomDatabase
    ): ProductDao = database.productDao()
}