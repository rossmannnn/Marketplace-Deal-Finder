package com.rossmannnn.marketplace.data.repository

import com.rossmannnn.marketplace.data.db.DealDao
import com.rossmannnn.marketplace.data.model.Deal
import kotlinx.coroutines.flow.Flow

class DealRepository(private val dealDao: DealDao) {

    fun getAllDeals(): Flow<List<Deal>> = dealDao.getAllDeals()

    fun getSavedDeals(): Flow<List<Deal>> = dealDao.getSavedDeals()

    fun getDealsByType(productType: String): Flow<List<Deal>> =
        dealDao.getDealsByType(productType)

    fun getDealsByPriceRange(minPrice: Double, maxPrice: Double): Flow<List<Deal>> =
        dealDao.getDealsByPriceRange(minPrice, maxPrice)

    fun getDealsByDistance(maxDistance: Double): Flow<List<Deal>> =
        dealDao.getDealsByDistance(maxDistance)

    suspend fun insertDeal(deal: Deal) {
        dealDao.insertDeal(deal)
    }

    suspend fun insertDeals(deals: List<Deal>) {
        dealDao.insertDeals(deals)
    }

    suspend fun updateDeal(deal: Deal) {
        dealDao.updateDeal(deal)
    }

    suspend fun deleteDeal(deal: Deal) {
        dealDao.deleteDeal(deal)
    }

    suspend fun deleteOldDeals(olderThan: Long) {
        dealDao.deleteOldDeals(olderThan)
    }

    fun getDealCount(): Flow<Int> = dealDao.getDealCount()
}
