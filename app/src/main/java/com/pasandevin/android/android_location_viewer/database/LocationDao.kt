package com.pasandevin.android.android_location_viewer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pasandevin.android.android_location_viewer.model.Location

@Dao
interface LocationDao {
    @Query("SELECT * FROM location")
    fun getAll(): List<Location>

    @Insert
    fun insert(vararg location: Location)
}