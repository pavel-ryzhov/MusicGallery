package com.example.musicgallery.presentation.albums

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicgallery.R
import com.example.musicgallery.models.local.albums.AlbumEntity
import com.google.android.material.textview.MaterialTextView

class AlbumsRecyclerAdapter(private val onItemClick: (album: String, artist: String) -> Unit): RecyclerView.Adapter<AlbumsRecyclerAdapter.AlbumViewHolder>() {

    private val albums = mutableListOf<AlbumEntity>()

    fun setAlbums(albums: List<AlbumEntity>){
        this.albums.clear()
        this.albums.addAll(albums)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AlbumViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_album_item, parent, false))

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.setAlbum(albums[position])
    }

    override fun getItemCount() = albums.size

    inner class AlbumViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        fun setAlbum(albumEntity: AlbumEntity){
            albumEntity.imageLocal?.let {
                Glide.with(view.context).load(it.text).into(view.findViewById<AppCompatImageView>(R.id.image_view))
            }
            view.findViewById<MaterialTextView>(R.id.text_view_album_name).text = albumEntity.albumLocal.name
            view.findViewById<View>(R.id.constraint_layout).setOnClickListener {
                albumEntity.artistLocal?.let {
                    onItemClick(albumEntity.albumLocal.name, it.name)
                }
            }
        }
    }

}