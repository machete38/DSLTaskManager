package com.example.dsltaskmanager.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dsltaskmanager.databinding.ActivityMainBinding
import com.example.dsltaskmanager.databinding.ItemTaskBinding

class TaskAdapter<T>() : ListAdapter<Task<T>, TaskAdapter<T>.TaskViewHolder>(TaskDiffCallback()) {

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task<T>) = with(binding)
        {
            taskTitle.text = task.title
            taskCategory.text = task.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val place = getItem(position)
        holder.bind(place)
    }

    class TaskDiffCallback<T> : DiffUtil.ItemCallback<Task<T>>() {
        override fun areItemsTheSame(oldItem: Task<T>, newItem: Task<T>): Boolean {
           return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Task<T>, newItem: Task<T>): Boolean {
          return oldItem == newItem
        }

    }
}