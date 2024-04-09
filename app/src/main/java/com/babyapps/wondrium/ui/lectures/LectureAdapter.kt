package com.babyapps.wondrium.ui.lectures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.babyapps.wondrium.data.model.lecture.Lecture
import com.babyapps.wondrium.databinding.ItemLectureBinding

class LectureAdapter : RecyclerView.Adapter<LectureAdapter.LectureViewHolder>() {

    inner class LectureViewHolder(val binding: ItemLectureBinding) :
        RecyclerView.ViewHolder(binding.root) {
        
            
    }

    val diffCallback = object : DiffUtil.ItemCallback<Lecture>() {

        override fun areItemsTheSame(
            oldItem: Lecture,
            newItem: Lecture
        ): Boolean =
            oldItem.lecture_magento_id == newItem.lecture_magento_id

        override fun areContentsTheSame(
            oldItem: Lecture,
            newItem: Lecture
        ): Boolean =
            oldItem == newItem

    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder =
        LectureViewHolder(
            ItemLectureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        val lecture = differ.currentList[position]

        holder.binding.apply {
            tvLectureName.text = "Lecture name : " + lecture.lecture_name
            tvContentBrand.text = "Content brand : " + lecture.content_brand
            tvDescription.text = "Description : " + lecture.lecture_description
        }
        holder.binding.root.setOnClickListener { onItemClickListener?.let { it(lecture) } }
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((Lecture) -> Unit)? = null

    fun setOnItemClickListener(listener: (Lecture) -> Unit) {
        onItemClickListener = listener
    }
}