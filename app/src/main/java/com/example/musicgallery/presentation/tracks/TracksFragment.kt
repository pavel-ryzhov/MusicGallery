package com.example.musicgallery.presentation.tracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.musicgallery.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TracksFragment : Fragment() {

    private val tracksViewModel: TracksViewModel by viewModels()
    private lateinit var recyclerAdapter: TracksRecyclerAdapter

    private var favourite = false
    private var albumName: String? = null
    private var artistName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tracks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAdapter = TracksRecyclerAdapter(tracksViewModel::updateTracks)

        arguments?.get("favourite")?.let {
            favourite = it as Boolean
        }

        if (!favourite) {
            albumName = arguments?.get("album") as String
            artistName = arguments?.get("artist") as String
        }

        val buttonBack = view.findViewById<MaterialButton>(R.id.button_back)
        val recyclerViewTracks = view.findViewById<RecyclerView>(R.id.recycler_view)
        val textViewAlbumName = view.findViewById<MaterialTextView>(R.id.text_view_album)

        textViewAlbumName.text = albumName ?: "Favourite tracks"

        recyclerViewTracks.adapter = recyclerAdapter

        buttonBack.setOnClickListener {
            findNavController().navigate(R.id.tagsFragment)
        }

        subscribeOnLiveData(albumName)

        albumName?.let { album ->
            artistName?.let { artist ->
                tracksViewModel.fetchTracks(album, artist)
            }
        }


    }

    private fun subscribeOnLiveData(albumName: String?) {
        if (albumName != null) {
            tracksViewModel.subscribeOnTracks(albumName).observe(viewLifecycleOwner){
                recyclerAdapter.setTracks(it)
            }
        }else {
            tracksViewModel.subscribeOnFavourite().observe(viewLifecycleOwner) {
                recyclerAdapter.setTracks(it)
            }
        }
    }
}