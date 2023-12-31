package com.example.growzen.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.growzen.Model.ModelSharing
import com.example.growzen.R

class PostAdapter(private val context: Context, private val postList: List<ModelSharing>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProfile: ImageView = itemView.findViewById(R.id.img_profile)
        val textUsername: TextView = itemView.findViewById(R.id.textUsername)
        val postTime: TextView = itemView.findViewById(R.id.postTime)
        val textContent: TextView = itemView.findViewById(R.id.textContent)
        val imageLike: ImageView = itemView.findViewById(R.id.imageLike)
        val likeCount: TextView = itemView.findViewById(R.id.LikeCount)
        val imageComment: ImageView = itemView.findViewById(R.id.imageComment)
        val commentCount: TextView = itemView.findViewById(R.id.CommentCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = postList[position]

        // Set data to views
        holder.imgProfile.setImageResource(currentPost.profileImage)
        holder.textUsername.text = currentPost.username
        holder.postTime.text = currentPost.postTime
        holder.textContent.text = currentPost.content
        holder.likeCount.text = currentPost.likeCount.toString() + " Likes"
        holder.commentCount.text = currentPost.commentCount.toString() + " Comments"
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}




