package com.sample.photogallery.api

import com.google.gson.annotations.SerializedName
import com.sample.photogallery.GalleryItem

class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}