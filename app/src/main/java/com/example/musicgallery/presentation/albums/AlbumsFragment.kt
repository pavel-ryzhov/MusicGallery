package com.example.musicgallery.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicgallery.R
import com.example.musicgallery.presentation.tags.TagsRecyclerAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsFragment : Fragment() {

    private val albumsViewModel: AlbumsViewModel by viewModels()
    private val recyclerAdapter = AlbumsRecyclerAdapter(this::onItemClick)
    private lateinit var albumsTag: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumsTag = arguments?.get("tag") as String

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val textViewTag = view.findViewById<MaterialTextView>(R.id.text_view_tag)
        val buttonBack = view.findViewById<MaterialButton>(R.id.button_back)

        buttonBack.setOnClickListener {
            findNavController().navigate(R.id.tagsFragment)
        }
        textViewTag.text = albumsTag
        recyclerView.layoutManager = GridLayoutManager(
            requireContext(),
            2,
            RecyclerView.VERTICAL,
            false
        )
        recyclerView.adapter = recyclerAdapter

        subscribeOnLiveData()

        albumsViewModel.fetchAlbums(albumsTag)
    }

    private fun onItemClick(album: String, artist: String){
        findNavController().navigate(AlbumsFragmentDirections.actionAlbumsFragmentToTracksFragment(album, artist))
    }

    private fun subscribeOnLiveData() {
        albumsViewModel.subscribeOnAlbums(albumsTag).observe(viewLifecycleOwner){
            recyclerAdapter.setAlbums(it)
        }
    }
}