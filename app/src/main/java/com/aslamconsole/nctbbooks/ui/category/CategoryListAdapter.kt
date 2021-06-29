package com.aslamconsole.nctbbooks.ui.category

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aslamconsole.nctbbooks.data.dto.Category
import com.aslamconsole.nctbbooks.databinding.LayoutCategoryItemBinding
import com.aslamconsole.nctbbooks.ui.book.BookActivity


/**
 * Created by Aslam Hossin on 6/28/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
class CategoryListAdapter :
    ListAdapter<Category, CategoryListAdapter.CategoryViewHolder>(CategoryDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(
        LayoutCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(getItem(position))


    inner class CategoryViewHolder(
        private val binding: LayoutCategoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) = with(itemView) {
            binding.root.setBackgroundColor(Color.parseColor(item.color))
            binding.textCategory.text = item.name
            binding.root.setOnClickListener {
                context.startActivity(
                    BookActivity.getCallingIntent(
                        context,
                        item.id
                    )
                )
            }
        }
    }


    private class CategoryDC : DiffUtil.ItemCallback<Category>() {

        override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Category, newItem: Category) =
            oldItem.id == newItem.id
    }
}