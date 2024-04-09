package com.babyapps.wondrium.data.model.course

data class Product(
    val content_blacklist: String,
    val content_brand: String,
    val content_classification: String,
    val content_partner: String,
    val content_restriction: String,
    val course_has_cc_video: Boolean,
    val course_has_hd_video: Boolean,
    val course_id: Int,
    val course_image_name: String,
    val course_name: String,
    val course_poster_image: String,
    val course_swatch_image: String,
    val course_url_key: String,
    val lecture_number: Int,
    val lecture_poster_image: String,
    val product_id: Int,
    val product_image_name: String,
    val product_name: String,
    val product_short_description: String,
    val product_sku: String,
    val product_sort_order: Int,
    val product_type: String
)