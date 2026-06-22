package com.rossmannnn.marketplace.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deals")
data class Deal(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val marketplaceUrl: String,
    val distance: Double,
    val productType: String,
    val dealScore: Double, // 0-100 score based on how good the deal is
    val foundAt: Long = System.currentTimeMillis(),
    val isSaved: Boolean = false
)

data class FilterCriteria(
    val productType: String = "",
    val minPrice: Double = 0.0,
    val maxPrice: Double = 10000.0,
    val distance: Double = 50.0, // km
    val numberOfPosts: Int = 50
)
