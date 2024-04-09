package com.babyapps.wondrium.data.model.lecture

data class Lecture(
    val content_brand: String,
    val content_classification: String,
    val lecture_allow_free_streaming: String,
    val lecture_bif_filename: String,
    val lecture_description: String,
    val lecture_image_filename: String,
    val lecture_magento_id: Int,
    val lecture_name: String,
    val lecture_number: Int,
    val lecture_sku: String,
    val lecture_soundtrack_filename: String,
    val lecture_video_filename: String,
    val time_in_minutes: String,
    val time_in_seconds: String
)