package com.example.musicgallery.presentation.tracks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.musicgallery.R
import com.example.musicgallery.models.local.tracks.TrackLocal
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class TracksRecyclerAdapter(private val updateTracks: (tracks: List<TrackLocal>) -> Unit) : RecyclerView.Adapter<TracksRecyclerAdapter.TracksViewHolder>() {

    private val tracks = mutableListOf<TrackLocal>()

    fun setTracks(tracks: List<TrackLocal>){
        this.tracks.clear()
        this.tracks.addAll(tracks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        return TracksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_track_item, parent, false))
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        holder.setTrack(tracks[position])
    }

    override fun getItemCount() = tracks.size

    inner class TracksViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private lateinit var buttonLike: MaterialButton
        fun setTrack(track: TrackLocal){
            view.findViewById<MaterialTextView>(R.id.text_view_track_name).text = track.name
            view.findViewById<MaterialTextView>(R.id.text_view_artist_name).text = track.artist
            buttonLike = view.findViewById(R.id.button_like)
            setButtonLikeBackground(track.favourite)
            buttonLike.setOnClickListener {
                track.favourite = !track.favourite
                setButtonLikeBackground(track.favourite)
                updateTracks(tracks)
            }
        }
        private fun setButtonLikeBackground(liked: Boolean){
            buttonLike.background = AppCompatResources.getDrawable(buttonLike.context, if (liked) R.drawable.like_filled else R.drawable.like)
        }
    }
}