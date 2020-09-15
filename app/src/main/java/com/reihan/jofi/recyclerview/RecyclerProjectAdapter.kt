package com.reihan.jofi.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reihan.jofi.R


class RecyclerProjectAdapter : RecyclerView.Adapter<RecyclerProjectAdapter.projectViewHolder>(){
    val itemRecycler = ItemClass()
    val listProject = itemRecycler.listProject
    val listDeadline = itemRecycler.listDeadline
    val listUrlImage = itemRecycler.listUrlImage

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): projectViewHolder {
        return projectViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_recycler_view_project,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: projectViewHolder, position: Int) {
        holder.imageUrl(listUrlImage[position],holder.imageUrlRecycler)
        holder.tvProject.text = listProject[position]
        holder.tvDeadline.text = listDeadline[position]
        holder.imageUrlRecycler.clipToOutline = true
    }

    override fun getItemCount(): Int =listProject.size

    class projectViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun imageUrl(url: String, Image: ImageView){
            Glide.with(itemView.context).load(url).placeholder(R.drawable.ava).into(Image)
        }
        var tvProject = itemView.findViewById<TextView>(R.id.title_recycler_view_project)
        var imageUrlRecycler = itemView.findViewById<ImageView>(R.id.image_recycler_view_project)
        var tvDeadline = itemView.findViewById<TextView>(R.id.deadline_recycler_view_project)
    }
}