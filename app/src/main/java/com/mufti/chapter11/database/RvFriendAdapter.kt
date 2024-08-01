package com.mufti.chapter11.database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mufti.chapter11.R

class RvFriendAdapter(
    private val context: Context,
    private val onItemClick: (position: Int, data: Friend) -> Unit
) : RecyclerView.Adapter<RvFriendAdapter.Companion.FriendViewHolder>() {

    private var listItem = emptyList<Friend>()

    companion object {
        class FriendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvName: TextView = view.findViewById(R.id.iv_nama)
            val tvSchool: TextView = view.findViewById(R.id.iv_sekolah)
            val tvHobby: TextView = view.findViewById(R.id.iv_hobby)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_friends, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val currentItem = listItem[position]

        holder.tvName.text = currentItem.name
        holder.tvSchool.text = currentItem.school
        holder.tvHobby.text = currentItem.hobby


        holder.itemView.setOnClickListener { onItemClick(position, currentItem) }
    }

    fun setData(list: List<Friend>) {
        this.listItem = list
        notifyDataSetChanged()
    }
}
