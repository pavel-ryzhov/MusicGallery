package com.example.musicgallery.presentation.tags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicgallery.R
import com.example.musicgallery.models.local.tags.TagLocal
import com.google.android.material.textview.MaterialTextView

class TagsRecyclerAdapter(
    private val onItemClick: (tag: String) -> Unit,
) : RecyclerView.Adapter<TagsRecyclerAdapter.TagViewHolder>() {

    private val tags = mutableListOf<TagLocal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TagViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_tag_item, parent, false),
        )

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.setTag(tags[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setTags(tags: List<TagLocal>) {
        this.tags.clear()
        this.tags.addAll(tags)
        notifyDataSetChanged()
    }

    override fun getItemCount() = tags.size

    inner class TagViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setTag(tag: TagLocal) {
            val textView = view.findViewById<MaterialTextView>(R.id.text_view_tag)
            textView.text = tag.name
            textView.setOnClickListener {
                onItemClick(tag.name)
            }
        }
    }
}