package com.rossmannnn.marketplace.data.db

import androidx.room.*
import com.rossmannnn.marketplace.data.model.Deal
import kotlinx.coroutines.flow.Flow

@Dao
interface DealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeal(deal: Deal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeals(deals: List<Deal>)

    @Update
    suspend fun updateDeal(deal: Deal)

    @Delete
    suspend fun deleteDeal(deal: Deal)

    @Query("SELECT * FROM deals ORDER BY dealScore DESC")
    fun getAllDeals(): Flow<List<Deal>>

    @Query("SELECT * FROM deals WHERE isSaved = 1 ORDER BY dealScore DESC")
    fun getSavedDeals(): Flow<List<Deal>>

    @Query("SELECT * FROM deals WHERE productType = :productType ORDER BY dealScore DESC")
    fun getDealsByType(productType: String): Flow<List<Deal>>

    @Query("SELECT * FROM deals WHERE price BETWEEN :minPrice AND :maxPrice ORDER BY dealScore DESC")
    fun getDealsByPriceRange(minPrice: Double, maxPrice: Double): Flow<List<Deal>>

    @Query("SELECT * FROM deals WHERE distance <= :maxDistance ORDER BY dealScore DESC")
    fun getDealsByDistance(maxDistance: Double): Flow<List<Deal>>

    @Query("DELETE FROM deals WHERE foundAt < :olderThan")
    suspend fun deleteOldDeals(olderThan: Long)

    @Query("SELECT COUNT(*) FROM deals")
    fun getDealCount(): Flow<Int>
}
