package com.rossmannnn.marketplace.domain.usecase

import com.rossmannnn.marketplace.data.model.Deal
import com.rossmannnn.marketplace.data.repository.DealRepository
import kotlinx.coroutines.flow.Flow

class GetDealsUseCase(private val repository: DealRepository) {

    operator fun invoke(): Flow<List<Deal>> = repository.getAllDeals()

    fun getSavedDeals(): Flow<List<Deal>> = repository.getSavedDeals()

    fun getDealsByType(productType: String): Flow<List<Deal>> =
        repository.getDealsByType(productType)

    fun getDealsByPriceRange(minPrice: Double, maxPrice: Double): Flow<List<Deal>> =
        repository.getDealsByPriceRange(minPrice, maxPrice)

    fun getDealsByDistance(maxDistance: Double): Flow<List<Deal>> =
        repository.getDealsByDistance(maxDistance)
}
