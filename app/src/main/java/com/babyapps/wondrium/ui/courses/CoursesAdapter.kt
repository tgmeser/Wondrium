package com.babyapps.wondrium.ui.courses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.babyapps.wondrium.data.model.Product
import com.babyapps.wondrium.databinding.ItemCourseBinding

class CoursesAdapter : RecyclerView.Adapter<CoursesAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val product = differ.currentList[position]

        holder.binding.apply {
            tvCourseName.text = product.course_name
            tvContentBrand.text = product.content_brand
            tvClassification.text = product.content_classification        }

        holder.binding.root.setOnClickListener { onItemClickListener?.let { it(product) } }
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        onItemClickListener = listener
    }
}