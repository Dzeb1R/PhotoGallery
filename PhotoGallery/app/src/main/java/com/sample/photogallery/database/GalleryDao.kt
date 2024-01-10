package com.sample.photogallery.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sample.photogallery.Item

@Dao
interface GalleryDao {
    @Query("SELECT * FROM gallery")
    fun getPhotos(): LiveData<List<Item>>

    @Insert
    fun addPhoto(item: Item)

    @Query("DELETE FROM gallery")
    fun deletePhotos()

    @Query("SELECT * FROM gallery WHERE url=(:url)")
    fun getPhoto(url: String): Item?
}