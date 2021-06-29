package com.aslamconsole.nctbbooks.ui.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aslamconsole.nctbbooks.data.dto.Book
import com.aslamconsole.nctbbooks.databinding.LayoutBookItemBinding
import com.bumptech.glide.Glide


/**
 * Created by Aslam Hossin on 6/28/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
class BookListAdapter : ListAdapter<Book, BookListAdapter.BookViewHolder>(CategoryDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BookViewHolder(
        LayoutBookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) =
        holder.bind(getItem(position))


    inner class BookViewHolder(
        private val binding: LayoutBookItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Book) = with(itemView) {
            binding.name.text = item.name
            Glide.with(this).load(item.image).into(binding.image)
            binding.banglaVersion.setOnClickListener {

            }
            binding.englishVersion.setOnClickListener {

            }
        }
    }


    private class CategoryDC : DiffUtil.ItemCallback<Book>() {

        override fun areItemsTheSame(oldItem: Book, newItem: Book) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Book, newItem: Book) =
            oldItem.name == newItem.name
    }
}