package com.rossmannnn.marketplace.domain.usecase

import com.rossmannnn.marketplace.data.model.Deal
import com.rossmannnn.marketplace.data.model.FilterCriteria
import com.rossmannnn.marketplace.data.repository.DealRepository
import com.rossmannnn.marketplace.data.scraper.MarketplaceScraper

class ScanMarketplaceUseCase(
    private val scraper: MarketplaceScraper,
    private val repository: DealRepository
) {

    suspend operator fun invoke(criteria: FilterCriteria): List<Deal> {
        // Scrape marketplace based on criteria
        val scrapedDeals = scraper.scrapeMarketplace(criteria)
        
        // Filter deals based on criteria
        val filteredDeals = scrapedDeals.filter { deal ->
            deal.price >= criteria.minPrice &&
            deal.price <= criteria.maxPrice &&
            deal.distance <= criteria.distance &&
            (criteria.productType.isEmpty() || 
             deal.productType.contains(criteria.productType, ignoreCase = true))
        }

        // Save to local database
        if (filteredDeals.isNotEmpty()) {
            repository.insertDeals(filteredDeals)
        }

        // Return only deals with good scores (> 60)
        return filteredDeals.filter { it.dealScore > 60.0 }
            .sortedByDescending { it.dealScore }
    }
}
