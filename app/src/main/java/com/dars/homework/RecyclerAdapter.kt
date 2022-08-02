package com.dars.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dars.homework.databinding.TableItemBinding
import com.dars.homework.model.UserItem

class RecyclerAdapter(
    val clickListener:(UserItem)->Unit
) : ListAdapter<UserItem, RecyclerAdapter.MyViewHolder>(diffUtill) {

    class MyViewHolder(val binding: TableItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffUtill = object : DiffUtil.ItemCallback<UserItem>() {
            override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem.company == newItem.company
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TableItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.binding.apply {
            txtOrder.text=(position+1).toString()
            txtName.text=user.name
            txtCity.text=user.address.city
            txtEmail.text=user.email
            txtUsername.text=user.username
        }
        holder.itemView.setOnClickListener {
            clickListener(user)
        }
    }
}