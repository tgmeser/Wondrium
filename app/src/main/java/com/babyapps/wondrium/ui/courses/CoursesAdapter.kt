package com.babyapps.wondrium.ui.courses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.babyapps.wondrium.data.model.course.Product
import com.babyapps.wondrium.databinding.ItemCourseBinding
import com.bumptech.glide.Glide

class CoursesAdapter : RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindImage(product: Product) {
            binding.apply {
                Glide.with(itemView)
                    .load("https://secureimages.teach12.com/tgc/images/m2/wondrium/courses/${product.course_id}/portrait/${product.course_id}.jpg")
                    .into(ivProductImage)
            }
        }
    }

    val diffCallback = object : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean =
            oldItem.course_id == newItem.course_id

        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean =
            oldItem == newItem

    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder =
        CourseViewHolder(
            ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val product = differ.currentList[position]

        holder.binding.apply {
            tvCourseName.text = "Course name : " + product.course_name
            tvContentBrand.text = "Content brand : " + product.content_brand
            tvClassification.text = "Classification : " + product.content_classification
        }
        holder.bindImage(product)
        holder.binding.root.setOnClickListener { onItemClickListener?.let { it(product) } }
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        onItemClickListener = listener
    }
}