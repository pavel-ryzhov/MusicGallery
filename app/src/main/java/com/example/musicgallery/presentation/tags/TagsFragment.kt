package com.example.musicgallery.presentation.tags

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
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TagsFragment : Fragment() {

    private val tagsViewModel: TagsViewModel by viewModels()
    private val recyclerAdapter = TagsRecyclerAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tags, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val buttonLogout = view.findViewById<MaterialButton>(R.id.button_logout)
        val textViewFavourites = view.findViewById<MaterialTextView>(R.id.text_view_favourite)

        textViewFavourites.setOnClickListener {
            findNavController().navigate(TagsFragmentDirections.actionTagsFragmentToTracksFragment(true))
        }

        buttonLogout.setOnClickListener {
            tagsViewModel.logout()
        }
        recyclerView.layoutManager = GridLayoutManager(
            requireContext(),
            2,
            RecyclerView.VERTICAL,
            false
        )
        recyclerView.adapter = recyclerAdapter

        subscribeOnLiveData()

        tagsViewModel.fetchTags()
    }

    private fun onItemClick(tag: String){
        findNavController().navigate(TagsFragmentDirections.actionTagsFragmentToAlbumsFragment(tag))
    }

    private fun subscribeOnLiveData() {
        tagsViewModel.apply {
            logoutLiveData.observe(viewLifecycleOwner) {
                findNavController().navigate(R.id.loginFragment)
            }
            tagsLiveData.observe(viewLifecycleOwner){
                recyclerAdapter.setTags(it)
            }
        }
    }
}