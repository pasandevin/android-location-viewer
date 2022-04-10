package com.pasandevin.android.android_location_viewer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Location (
    @PrimaryKey
    var name: String,
    var latitude: Double,
    var longitude: Double
    )